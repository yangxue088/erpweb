package com.erp.dao.product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.erp.service.publish.Product;
import com.erp.util.FileUtil;

@Repository
public class ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final LobHandler lobHandler = new DefaultLobHandler();

	public void savePicture(final String filename, final InputStream is, final int productId) {
		jdbcTemplate.execute("insert into picture(type, file, pid, create_time, update_time) values (?, ?, ?, null, null)", new AbstractLobCreatingPreparedStatementCallback(lobHandler) {

			protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException, DataAccessException {
				try {
					ps.setString(1, filename.substring(filename.lastIndexOf('.') + 1));
					lobCreator.setBlobAsBinaryStream(ps, 2, is, is.available());
					ps.setInt(3, productId);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		});
	}

	public int createProduct(final Product product) {
		jdbcTemplate.update("insert into product(type, title, json, gid, create_time, update_time) values (?, ?, ?, ?, null, null)", new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, product.getType());
				ps.setString(2, product.getTitle());
				ps.setString(3, product.getJson());
				ps.setInt(4, product.getGid());
			}
		});

		return jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
	}

	public void updateProduct(final int id, final Product product) {
		jdbcTemplate.update("update product set type=?, title=?, json=?, gid=? where id=?", new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, product.getType());
				ps.setString(2, product.getTitle());
				ps.setString(3, product.getJson());
				ps.setInt(4, product.getGid());
				ps.setInt(5, id);
			}
		});
	}

	public void createStocks(final int productId, List<String[]> stocks) {
		for (final String[] stock : stocks) {
			jdbcTemplate.update("insert into stock(product_id, sale, color, inventory, code, create_time, update_time) values(?, ?, ?, ?, ?, null, null)", new PreparedStatementSetter() {
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setInt(1, productId);
					ps.setString(2, stock[0]);
					ps.setString(3, stock[1]);
					ps.setInt(4, Integer.parseInt(stock[2]));
					ps.setString(5, stock[3]);
				}
			});
		}
	}

	public void updateStocks(int productId, List<String[]> stocks) {
		jdbcTemplate.update("delete from stock where product_id=?", new Object[] { productId });

		createStocks(productId, stocks);
	}

	public Product getProduct(int id) {
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet("select type, title, json, gid from product where id=?", new Object[] { id });

		while (rowSet.next()) {
			Product product = new Product();
			product.setType(rowSet.getString("type"));
			product.setTitle(rowSet.getString("title"));
			product.setJson(rowSet.getString("json"));
			product.setGid(rowSet.getInt("gid"));
			return product;
		}

		return null;
	}

	public List<String[]> getStocks(int productId) {
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet("select sale, color, inventory, code from stock where product_id=?", new Object[] { productId });

		List<String[]> stocks = new ArrayList<String[]>();
		while (rowSet.next()) {
			String[] stock = new String[4];

			stock[0] = rowSet.getString("sale");
			stock[1] = rowSet.getString("color");
			stock[2] = String.valueOf(rowSet.getInt("inventory"));
			stock[3] = rowSet.getString("code");

			stocks.add(stock);
		}

		return stocks;
	}

	public List<String> getPictures(final int productId, final String topath) {
		return jdbcTemplate.query("select id, type, file from picture where pid=?", new Object[] { productId }, new RowMapper<String>() {

			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id = rs.getInt("id");
				String type = rs.getString("type");
				InputStream is = lobHandler.getBlobAsBinaryStream(rs, "file");

				String filename = String.valueOf(id) + "." + type;

				File file = new File(topath + File.separator + filename);

				FileUtil.createNewFile(file.getAbsolutePath(), true);

				try {
					IOUtils.copy(is, new FileOutputStream(file));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				return filename;
			}

		});
	}

	public void deletePicture(int id) {
		jdbcTemplate.update("delete from picture where id=?", new Object[] { id });
	}

	public List<String[]> getProductBrief(String paramQuery1, String paramQuery2, int offset, int limit) {
		List<String[]> result = new ArrayList<String[]>();
		
		String sql = String.format("select bp.id as id, bp.title as title, bp.gname as cate, sum(bp.stock) as stock from (select p.id as id, p.title as title, p.gid as gid, c.name as gname, s.code as code, s.inventory as stock, p.create_time as crtime from product as p, stock as s, category as c where p.id = s.product_id and p.gid = c.id) as bp where (%s) group by bp.id having (%s) order by bp.crtime desc limit %d offset %d", paramQuery1, paramQuery2, limit, offset);
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
		while (rowSet.next()) {
			String[] res = new String[4];

			res[0] = rowSet.getString("id");
			res[1] = rowSet.getString("title");
			res[2] = rowSet.getString("cate");
			res[3] = String.valueOf(rowSet.getInt("stock"));

			result.add(res);
		}
		return result;
	}

}

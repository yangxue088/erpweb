package com.erp.service.product;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.bean.category.Cate;
import com.erp.dao.product.ProductDao;
import com.erp.service.category.AbstCateService;
import com.erp.service.category.JsonNode;
import com.erp.service.publish.Product;

@Service
public class ProductService extends AbstCateService {

	@Autowired
	private ProductDao productDao;

	public void createPicture(String filename, InputStream is, int productId) {
		productDao.savePicture(filename, is, productId);
	}

	public int createProduct(Product product) {
		int productId = productDao.createProduct(product);
		productDao.createStocks(productId, product.getStocks());
		return productId;
	}

	public void updateProduct(int id, Product product) {
		productDao.updateProduct(id, product);

		updateStocks(id, product.getStocks());
	}

	public void updateStocks(int id, List<String[]> stocks) {
		productDao.updateStocks(id, stocks);
	}

	public Product getProduct(int productId) {
		return productDao.getProduct(productId);
	}

	public List<String> getPictures(int productId, String topath) {
		return productDao.getPictures(productId, topath);
	}

	public List<String[]> getStocks(int productId) {
		return productDao.getStocks(productId);
	}

	public void deletePicture(int id) {
		productDao.deletePicture(id);
	}

	public JsonTable getProductTable(int state, String title, String code, String group, String inventory, int offset, int limit) {
		StringBuffer paramQuery1 = new StringBuffer();
		StringBuffer paramQuery2 = new StringBuffer();

		List<String> psub1 = new ArrayList<String>();
		if (StringUtils.isNotEmpty(title)) {
			psub1.add("bp.title like '%" + title + "%'");
		}

		if (StringUtils.isNotEmpty(code)) {
			psub1.add("bp.code like '%" + code + "%'");
		}

		if (!"all".equals(group.toLowerCase())) {
			psub1.add("bp.gid=" + group);
		}

		paramQuery1.append(StringUtils.join(psub1, " and "));

		if (!"all".equals(inventory.toLowerCase())) {
			paramQuery2.append("sum(bp.stock)=" + Integer.valueOf(inventory));
		}

		if (paramQuery1.length() == 0) {
			paramQuery1.append("1=1");
		}

		if (paramQuery2.length() == 0) {
			paramQuery2.append("1=1");
		}

		List<String[]> products = productDao.getProductBrief(paramQuery1.toString(), paramQuery2.toString(), offset, limit);

		JsonTable table = new JsonTable();
		table.setTotal(products.size());
		for (final String[] product : products) {
			if (state == Integer.parseInt(product[4])) {
				table.getRows().add(new HashMap<String, String>() {
					private static final long serialVersionUID = 1L;
					{
						put("id", product[0]);
						put("title", product[1]);
						put("group", product[2]);
						put("inventory", product[3]);
					}
				});
			}
		}

		return table;
	}

	public void setProductState(int id, int state) {
		productDao.setProductState(id, state);
	}

	@Override
	public JsonNode wrap(Cate cate) {
		JsonNode node = new JsonNode("nodes");
		if (cate != null) {
			node.setAttribute("text", cate.getName());
			if (cate.getDepth() == 0) {
				node.setAttribute("selectable", false);
			}
		}
		return node;
	}

	public void updateGroup(List<String> ids, String group) {
		productDao.updateGroup(ids, group);
	}
}

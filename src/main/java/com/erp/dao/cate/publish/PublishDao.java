package com.erp.dao.cate.publish;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.stereotype.Repository;

@Repository
public class PublishDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int savepic(final String filename, final InputStream is) {
		jdbcTemplate
				.execute(
						"insert into picture(name, file, create_time, update_time) values (?, ?, null, null)",
						new AbstractLobCreatingPreparedStatementCallback(
								new DefaultLobHandler()) {

							protected void setValues(PreparedStatement ps,
									LobCreator lobCreator) throws SQLException,
									DataAccessException {
								try {
									ps.setString(1, filename);
									lobCreator.setBlobAsBinaryStream(ps, 2, is,
											is.available());
								} catch (IOException e) {
									e.printStackTrace();
								}
							}

						});
		
		int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
		
		return id;
	}

}

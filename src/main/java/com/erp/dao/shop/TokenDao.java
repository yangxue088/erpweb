package com.erp.dao.shop;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.erp.service.aliexpress.AliToken;

@Repository
public class TokenDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private SimpleDateFormat easysdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSSZ");

	public Integer createAliToken(String aliId, String resource_owner, String access_token, String expires_in, String refresh_token, String refresh_token_timeout) {
		jdbcTemplate.update("insert into token_alibaba(ali_id, resource_owner, refresh_token, refresh_token_timeout, access_token, expires_in, create_time, update_time) values(?,?,?,?,?,?,null,null)", aliId, resource_owner, refresh_token, refresh_token_timeout, access_token, expires_in);

		return jdbcTemplate.queryForObject("select id from token_alibaba where ali_id=?", new Object[] { aliId }, Integer.class);
	}

	public void updateAliToken(int tokenId, AliToken aliToken) {
		jdbcTemplate.update("update token_alibaba set ali_id=?, resource_owner=?, refresh_token=?, refresh_token_timeout=?, access_token=?, expires_in=? where id=?", new Object[] { aliToken.getAliId(), aliToken.getResourceOwner(), aliToken.getRefreshToken(), aliToken.getRefreshTokenTimeout(), aliToken.getAccessToken(), aliToken.getExpiresIn(), tokenId });
	}

	public AliToken getAliToken(int id) {
		return jdbcTemplate.queryForObject("select * from token_alibaba where id=?", new Object[] { id }, new AliTokenMapper());
	}

	private class AliTokenMapper implements RowMapper<AliToken> {

		@Override
		public AliToken mapRow(ResultSet rs, int rowNum) throws SQLException {
			AliToken aliToken = new AliToken();
			try {
				aliToken.setId(rs.getInt("id"));
				aliToken.setAliId(rs.getString("ali_id"));
				aliToken.setResourceOwner(rs.getString("resource_owner"));
				aliToken.setRefreshToken(rs.getString("refresh_token"));
				aliToken.setRefreshTokenTimeout(easysdf.format(sdf.parse(rs.getString("refresh_token_timeout"))));
				aliToken.setAccessToken(rs.getString("access_token"));
				aliToken.setExpiresIn(rs.getString("expires_in"));
				aliToken.setUpdateTime(easysdf.format(rs.getTimestamp("update_time")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return aliToken;
		}

	}

}

package com.erp.dao.shop;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.erp.service.aliexpress.AliToken;

@Repository
public class TokenDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private SimpleDateFormat easysdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public Integer createAliToken(String aliId, String resource_owner, String access_token, String expires_in, String refresh_token, String refresh_token_timeout) {
		jdbcTemplate.update("insert into alibaba_token(ali_id, resource_owner, refresh_token, refresh_token_timeout, access_token, expires_in, create_time, update_time) values(?,?,?,?,?,?,null,null)", aliId, resource_owner, refresh_token, refresh_token_timeout, access_token, expires_in);

		return jdbcTemplate.queryForObject("select id from alibaba_token where ali_id=?", new Object[] { aliId }, Integer.class);
	}

	public void updateAliToken(int tokenId, AliToken aliToken) {
		jdbcTemplate.update("update alibaba_token set ali_id=?, resource_owner=?, refresh_token=?, refresh_token_timeout=?, access_token=?, expires_in=? where id=?", new AliTokenSetter(aliToken));
	}

	public AliToken getAliToken(int id) {
		return jdbcTemplate.queryForObject("select * from alibaba_token where id=?", new Object[] { id }, new AliTokenMapper());
	}

	private class AliTokenSetter implements PreparedStatementSetter {

		private AliToken aliToken;

		private AliTokenSetter(AliToken aliToken) {
			this.aliToken = aliToken;
		}

		@Override
		public void setValues(PreparedStatement ps) throws SQLException {
			ps.setString(1, aliToken.getAliId());
			ps.setString(2, aliToken.getResourceOwner());
			ps.setString(3, aliToken.getRefreshToken());
			ps.setString(4, aliToken.getRefreshTokenTimeout());
			ps.setString(5, aliToken.getAccessToken());
			ps.setString(6, aliToken.getExpiresIn());
			ps.setInt(7, aliToken.getId());
		}

	}

	private class AliTokenMapper implements RowMapper<AliToken> {

		@Override
		public AliToken mapRow(ResultSet rs, int rowNum) throws SQLException {
			AliToken aliToken = new AliToken();
			aliToken.setId(rs.getInt("id"));
			aliToken.setAliId(rs.getString("ali_id"));
			aliToken.setResourceOwner(rs.getString("resource_owner"));
			aliToken.setRefreshToken(rs.getString("refresh_token"));
			aliToken.setRefreshTokenTimeout(rs.getString("refresh_token_timeout"));
			aliToken.setAccessToken(rs.getString("access_token"));
			aliToken.setExpiresIn(rs.getString("expires_in"));
			aliToken.setUpdateTime(easysdf.format(rs.getTimestamp("update_time")));
			return aliToken;
		}

	}

}

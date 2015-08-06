package com.erp.dao.cate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.erp.bean.cate.Cate;
import com.google.common.collect.Lists;

@Repository
public class CateDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Cate> getCates() {
		List<Cate> cates = Lists.newArrayList();

		SqlRowSet rs = jdbcTemplate
				.queryForRowSet("select node.name as name, (count(parent.name) - 1) as depth from category as node, category as parent where node.lft between parent.lft and parent.rgt group by node.name order by node.lft");

		while (rs.next()) {
			Cate cate = new Cate();
			cate.setName(rs.getString("name"));
			cate.setDepth(rs.getInt("depth"));
			cates.add(cate);
		}

		return cates;
	}

}

package com.erp.dao.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.erp.bean.category.Cate;
import com.google.common.collect.Lists;

@Repository
public class CateDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Cate> getCates() {
		List<Cate> cates = Lists.newArrayList();

		SqlRowSet rs = jdbcTemplate
				.queryForRowSet("select node.id as id, node.name as name, (count(parent.name) - 1) as depth, node.lft as lft, node.rgt as rgt from category as node, category as parent where node.lft between parent.lft and parent.rgt group by node.name order by node.lft");

		while (rs.next()) {
			Cate cate = new Cate();
			cate.setId(rs.getString("id"));
			cate.setName(rs.getString("name"));
			cate.setDepth(rs.getInt("depth"));
			cate.setLft(rs.getInt("lft"));
			cate.setRgt(rs.getInt("rgt"));
			cates.add(cate);
		}

		return cates;
	}

	public Cate getCate(String id) {
		SqlRowSet rs = jdbcTemplate
				.queryForRowSet(
						"select node.id as id, node.name as name, node.lft as lft, node.rgt as rgt from category as node where node.id=?",
						id);

		while (rs.next()) {
			Cate cate = new Cate();
			cate.setId(rs.getString("id"));
			cate.setName(rs.getString("name"));
			cate.setLft(rs.getInt("lft"));
			cate.setRgt(rs.getInt("rgt"));
			return cate;
		}

		return null;
	}

	public Cate getCateName(String name) {
		SqlRowSet rs = jdbcTemplate
				.queryForRowSet(
						"select node.id as id, node.name as name, node.lft as lft, node.rgt as rgt from category as node where node.name=?",
						name);

		while (rs.next()) {
			Cate cate = new Cate();
			cate.setId(rs.getString("id"));
			cate.setName(rs.getString("name"));
			cate.setLft(rs.getInt("lft"));
			cate.setRgt(rs.getInt("rgt"));
			return cate;
		}

		return null;
	}

	public void uptCate(String id, Cate cate) {
		jdbcTemplate.update("update category set name=? where id=?",
				cate.getName(), id);
	}

	public void sort(String sname, String tname) {
		jdbcTemplate.update("{call category_sort_node(?, ?)}", sname, tname);
	}

	public void delCate(String name) {
		jdbcTemplate.update("{call category_delete_node(?)}", name);
	}

	public Cate addCate(String pname, String name, boolean child) {
		if (child) {
			jdbcTemplate.update("{call category_create_child(?, ?)}", pname,
					name);
		} else {
			jdbcTemplate.update("{call category_create_brother(?, ?)}", pname,
					name);
		}
		return getCateName(name);
	}

}

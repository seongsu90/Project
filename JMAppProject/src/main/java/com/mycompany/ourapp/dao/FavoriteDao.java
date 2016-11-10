package com.mycompany.ourapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class FavoriteDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(String fMid, int fResid) {
		String sql = "insert into favorite(fmid, fresid) values(?, ?)";
		int row = jdbcTemplate.update(sql, fMid, fResid);
		return row;
	}

	public int delete(String fMid, int fResid) {
		String sql = "delete from favorite where fmid=? and fresid=?;";
		int row = jdbcTemplate.update(sql, fMid, fResid);
		return row;
	}

}

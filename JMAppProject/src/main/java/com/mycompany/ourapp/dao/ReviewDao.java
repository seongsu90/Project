package com.mycompany.ourapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.ourapp.dto.Review;

@Component
public class ReviewDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(Review review) {
		String sql = "insert into review(revno, revresid, revmid, revcontent, revscore, revdate) values(?, ?, ?, ?, 0, sysdate)";
		int row = jdbcTemplate.update(
				sql,
				review.getRevno(),     // 시퀀스?
				review.getRevResid(),
				review.getRevMid(),
				review.getRevcontent()
		);
		return row;		
	}

	public int delete(int revno, int revMid) {
		String sql = "delete from review where revno=? and revMid=?";
		int row = jdbcTemplate.update(sql, revno, revMid);
		return row;
	}

	public Review selectInfo(int revno) {
		String sql = "select revno, revresid, revmid, revcontent, revscore, revdate from review where revno=? ";
		List<Review> list =  jdbcTemplate.query(sql, new Object[] {revno}, new RowMapper<Review>() {
			@Override
			public Review mapRow(ResultSet rs, int row) throws SQLException {
				Review review = new Review();
				review.setRevno(rs.getInt("revno"));
				review.setRevResid(rs.getInt("revresid"));
				review.setRevMid(rs.getString("revmid"));
				review.setRevcontent(rs.getString("revcontent"));
				review.setRevscore(rs.getInt("revscore"));
				review.setRevdate(rs.getDate("revdate"));
				return review;
			}	
		});				
		return (list.size() != 0) ? list.get(0) : null;
	}
}

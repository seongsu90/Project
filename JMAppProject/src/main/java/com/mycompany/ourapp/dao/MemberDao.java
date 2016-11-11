package com.mycompany.ourapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.ourapp.dto.Member;

@Component
public class MemberDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(Member member) {
		String sql = "insert into member(mid, mname, mpassword, mphone, mbirth, mlocation) values(?, ?, ?, ?, ?, ?, 0, 0, 0)";
		int row = jdbcTemplate.update(
				sql,
				member.getMid(),
				member.getMname(),
				member.getMpassword(),
				member.getMphone(),
				member.getMbirth(),
				member.getMlocation()
		);
		return row;
	}
	
	public int update(Member member) {
		String sql = "update member set mpassword=?, mphone=?, mlocation=?, mrank=?, mpoint=?, mresid=? where mid=?";
		int row = jdbcTemplate.update(
				sql,
				member.getMpassword(),
				member.getMphone(),
				member.getMlocation(),
				member.getMrank(),
				member.getMpoint(),
				member.getMResid(),
				member.getMid()
		);
		return row;
	}

	public int delete(String mid) {
		String sql = "delete from member where mid=?";
		int row = jdbcTemplate.update(sql, mid);
		return row;		
	}

	public Member selectByMid(String mid) {
		String sql = "select mid, mname, mpassword, mphone, mbirth, mlocation, mrank, mpoint, mresid from member where mid=?";
		
		List<Member> list = jdbcTemplate.query(sql, new Object[] {mid}, new RowMapper<Member>(){
			@Override
			public Member mapRow(ResultSet rs, int row) throws SQLException {
				Member member = new Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				member.setMpassword(rs.getString("mpassword"));
				member.setMphone(rs.getString("mphone"));
				member.setMbirth(rs.getDate("mbirth"));
				member.setMlocation(rs.getString("mlocation"));
				member.setMrank(rs.getInt("mrank"));
				member.setMpoint(rs.getInt("mpoint"));
				member.setMResid(rs.getInt("mResid"));
				return member;
			}
		});
		return (list.size() != 0)?list.get(0) : null;	
	}

	public String selectMidByMnameAndMphone(String mname, String mphone) {
		String sql = "select mid from member where mname=? and mphone=?";
		
		List<String> list = jdbcTemplate.query(sql, new Object[] {mname, mphone}, new RowMapper<String>(){
			@Override
			public String mapRow(ResultSet rs, int row) throws SQLException {
				return rs.getString("mid");
			}
		});
		return (list.size() != 0)?list.get(0) : null;
	}
	
}

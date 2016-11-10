package com.mycompany.ourapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mycompany.ourapp.dto.Member;

public class MemberDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(Member member) {
		String sql = "insert into member(mid, mname, mpassword, mphone, mbirth, mlocation, mresid) values(?, ?, ?, ?, ?, ?, 0, 0, 0)";
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

	public void delete(String mid) {
		// TODO Auto-generated method stub
		
	}

	public Member selectByMid(String mid) {
		// TODO Auto-generated method stub
		return null;
	}

	public String selectByMnameAndMphone(String mname, String mphone) {
		// TODO Auto-generated method stub
		return null;
	}

	public Member selectByMidAndMphone(String mid, String mphone) {
		// TODO Auto-generated method stub
		return null;
	}



}

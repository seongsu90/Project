package com.mycompany.ourapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.ourapp.dto.Coupon;
import com.mycompany.ourapp.dto.Event;

@Component
public class EventDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//이벤트 생성
	public int insert(Event event){
		String sql="insert into event(ename,eresid,esavedfile,einfo,emlname,eprice,estart,eend), values(?,?,?,?,?,?,?,?)";
		int row = jdbcTemplate.update(
				sql,
				event.getEname(),
				event.geteResid(),
				event.getEsavedfile(),
				event.getEinfo(),
				event.geteMlname(),
				event.getEprice(),
				event.getEstart(),
				event.getEend()
				);
		return row;
	}
	//이벤트 삭제
	public int delete(int eResid, String eMlname){
		String sql="delete from event where eresid=? and emlname=?";
		int row = jdbcTemplate.update(sql, eResid, eMlname);
		return row;
	}
	//이벤트 추가
	public int update(Event event){
		String sql = "update event set ename=?,esavedfile=?,einfo=?,emlname=?,eprice=?,estart=?,eend=? where eresid=?";
		int row = jdbcTemplate.update(
				sql,
				event.getEname(),
				event.getEsavedfile(),
				event.getEinfo(),
				event.geteMlname(),
				event.getEprice(),
				event.getEstart(),
				event.getEend(),
				event.geteResid()
				);
		return row;
	}
	
	public Event selectByEResidAndEMlname(int eResid, String eMlname) {
		String sql = "select * from event where eResid=? and eMlname=?";
		List<Event> list = jdbcTemplate.query(sql, new Object[]{eResid,eMlname}, new RowMapper<Event>() {
			@Override
			public Event mapRow(ResultSet rs, int row) throws SQLException {
				Event event = new Event();
				event.setEname(rs.getString("ename"));
				event.setEsavedfile(rs.getString("esavedfile"));
				event.setEinfo(rs.getString("einfo"));
				event.setEprice(rs.getInt("eprice"));
				event.setEstart(rs.getDate("estart"));
				event.setEend(rs.getDate("eend"));
				
				return event;
			}
		});
		return (list.size() != 0)?list.get(0) : null;
	}
	
}
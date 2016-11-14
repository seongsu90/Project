package com.mycompany.ourapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.ourapp.dto.Event;

@Component
public class EventDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(Event event){
		String sql="insert into event(ename,eresid,esavedfile,einfo,emlname,eprice,estart,eend) values(?,?,?,?,?,?,?,?)";
		int row = jdbcTemplate.update(
				sql,
				event.getEname(),
				event.getEresid(),
				event.getEsavedfile(),
				event.getEinfo(),
				event.getEmlname(),
				event.getEprice(),
				event.getEstart(),
				event.getEend()
				);
		return row;
	}
	
	public int delete(int eresid, String emlname){
		String sql="delete from event where eresid=? and emlname=?";
		int row = jdbcTemplate.update(sql, eresid, emlname);
		return row;
	}
	
	public int update(Event event){
		String sql = "update event set ename=?,esavedfile=?,einfo=?,emlname=?,eprice=?,estart=?,eend=? where eresid=?";
		int row = jdbcTemplate.update(
				sql,
				event.getEname(),
				event.getEsavedfile(),
				event.getEinfo(),
				event.getEmlname(),
				event.getEprice(),
				event.getEstart(),
				event.getEend(),
				event.getEresid()
				);
		return row;
	}
	
	public Event selectByEresidAndEmlname(int eresid, String emlname) {
		String sql = "select * from event where eresid=? and emlname=?";
		List<Event> list = jdbcTemplate.query(sql, new Object[]{eresid,emlname}, new RowMapper<Event>() {
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
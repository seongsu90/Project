package com.mycompany.ourapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.mycompany.ourapp.dto.Event;

@Component
public class EventDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
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
	
	public int delete(int eResid, String eMlname){
		String sql="delete from event where eresid=? and emlname=?";
		int row = jdbcTemplate.update(sql, eResid, eMlname);
		return row;
	}
	
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
	
}
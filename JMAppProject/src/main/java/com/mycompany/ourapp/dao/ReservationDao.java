package com.mycompany.ourapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.mycompany.ourapp.dto.Reservation;



@Component
public class ReservationDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Reservation reservation) {
		String sql = "insert into reservation(rvtime, rvperson, rvMid, rvResid) values(sysdate, ?, ?, ?)";
		int row = jdbcTemplate.update(
				sql,
				reservation.getRvtime(),
				reservation.getRvperson(),
				reservation.getRvMid(),
				reservation.getRvResid()
		);		
		return row;
	}
	
	public int delete(String rvMid, int rvResid) {
		String sql = "delete from reservation where rvMid=? and rvResid=?";
		int row = jdbcTemplate.update( sql, rvMid, rvResid );		
		return row;
	}
	
	public Reservation selectById(String rvMid, int rvResid) {
		String sql = "select * where rvMid=? and rvResid=?";
		List<Reservation> list = jdbcTemplate.query(sql, new Object[]{rvMid, rvResid}, new RowMapper<Reservation>() {
			@Override
			public Reservation mapRow(ResultSet rs, int row) throws SQLException {
				Reservation reservation = new Reservation();
				reservation.setRvtime(rs.getDate("rvtime"));
				reservation.setRvperson(rs.getInt("rvperson"));
				reservation.setRvMid(rs.getString("rvMid"));
				reservation.setRvResid(rs.getInt("rvResid"));
				
				return reservation;
			}
		});
		return (list.size() != 0)?list.get(0) : null;
	}
}

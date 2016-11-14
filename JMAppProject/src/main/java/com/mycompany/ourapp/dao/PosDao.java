package com.mycompany.ourapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.ourapp.dto.Pos;

@Component
public class PosDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(Pos pos) {
		String sql = "insert into pos(ptableno, presid, pmlname, pcount) values(?, ?, ?, ?)";
		int row = jdbcTemplate.update(
				sql,
				pos.getPtableno(),
				pos.getpResid(),
				pos.getpMlname(),
				pos.getPcount()
		);
		return row;		
	}

	public int update(Pos pos) {
		String sql = "update pos set pMlname=?, pcount=? where ptableno=? and presid=?";
		int row = jdbcTemplate.update(
				sql,
				pos.getpMlname(),
				pos.getPcount(),
				pos.getPtableno(),
				pos.getpResid()
		);
		return row;
	}

	public int delete(int ptableno, int pResid) {
		String sql = "delete from pos where ptableno=? and presid=?";
		int row = jdbcTemplate.update(sql, ptableno, pResid);
		return row;
	}
	
	public Pos selectInfo(int ptableno, int pResid) {
		String sql = "select ptableno, presid, pmlname, pcount from pos where presid=?, ptableno=?";
		List<Pos> list =  jdbcTemplate.query(sql, new Object[] {pResid, ptableno}, new RowMapper<Pos>() {
			@Override
			public Pos mapRow(ResultSet rs, int row) throws SQLException {
				Pos pos = new Pos();
				pos.setpMlname(rs.getString("pmlname"));
				pos.setPcount(rs.getInt("pcount"));
				pos.setpResid(rs.getInt("presid"));
				pos.setPtableno(rs.getInt("ptableno"));				
				return pos;
			}	
		});				
		return (list.size() !=0) ? list.get(0) : null;
	}

	public List<Integer> calc(int ptableno, int pResid) {
		String sql = "";
				sql += "select (m.mlprice * p.pcount) price ";
				sql += "from pos p, menulist m ";
				sql += "where p.presid = m.mlresid ";
				sql += "and p.pmlname = m.mlname ";
				sql += "and p.ptableno = ? ";
				sql += "and p.presid = ? ";
		
		List<Integer> list =  jdbcTemplate.query(sql, new Object[] {ptableno, pResid}, new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int row) throws SQLException {
				
				return rs.getInt("price");
			}
		});
		
		return list;
	}
	
	public List<Pos> list(int pResid) {
		String sql = "select ptableno, pmlname, pcount from pos where presid=?";
		List<Pos> list = jdbcTemplate.query(sql, new Object[] {pResid}, new RowMapper<Pos>() {
			@Override
			public Pos mapRow(ResultSet rs, int row) throws SQLException {
				Pos pos = new Pos();
				pos.setPtableno(rs.getInt("ptableno"));
				pos.setpMlname(rs.getString("pmlname"));
				pos.setPcount(rs.getInt("pcount"));
					
				return pos;
			}
		});
		return list;
	}
}

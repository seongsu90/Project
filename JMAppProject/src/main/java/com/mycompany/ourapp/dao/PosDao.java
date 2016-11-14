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
				pos.getPresid(),
				pos.getPmlname(),
				pos.getPcount()
		);
		return row;		
	}

	public int update(Pos pos) {
		String sql = "update pos set pmlname=?, pcount=? where presid=? and ptableno=?";
		int row = jdbcTemplate.update(
				sql,
				pos.getPmlname(),
				pos.getPcount(),
				pos.getPtableno(),
				pos.getPresid()
		);
		return row;
	}

	public int delete(int ptableno, int presid) {
		String sql = "delete from pos where presid=? and ptableno=?";
		int row = jdbcTemplate.update(sql, presid, ptableno);
		return row;
	}
	
	public List<Pos> selectInfo(int presid, int ptableno) {
		String sql = "select presid, ptableno, pmlname, pcount from pos where presid=? and ptableno=?";
		List<Pos> list =  jdbcTemplate.query(sql, new Object[] {presid, ptableno}, new RowMapper<Pos>() {
			@Override
			public Pos mapRow(ResultSet rs, int row) throws SQLException {
				Pos pos = new Pos();
				pos.setPresid(rs.getInt("presid"));
				pos.setPtableno(rs.getInt("ptableno"));	
				pos.setPmlname(rs.getString("pmlname"));
				pos.setPcount(rs.getInt("pcount"));
							
				return pos;
			}	
		});				
		return list;
	}

	public List<Integer> calc(int presid, int ptableno) {
		String sql = "";
				sql += "select (m.mlprice * p.pcount) price ";
				sql += "from pos p, menulist m ";
				sql += "where p.presid = m.mlresid ";
				sql += "and p.pmlname = m.mlname ";
				sql += "and p.presid = ? ";
				sql += "and p.ptableno = ? ";
		
		List<Integer> list =  jdbcTemplate.query(sql, new Object[] {presid, ptableno}, new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int row) throws SQLException {
				
				return rs.getInt("price");
			}
		});
		
		return list;
	}
	
	public List<Pos> list(int presid) {
		String sql = "select presid, ptableno, pmlname, pcount from pos where presid=?";
		List<Pos> list = jdbcTemplate.query(sql, new Object[] {presid}, new RowMapper<Pos>() {
			@Override
			public Pos mapRow(ResultSet rs, int row) throws SQLException {
				Pos pos = new Pos();	
				pos.setPresid(rs.getInt("presid"));
				pos.setPtableno(rs.getInt("ptableno"));
				pos.setPmlname(rs.getString("pmlname"));
				pos.setPcount(rs.getInt("pcount"));
					
				return pos;
			}
		});
		return list;
	}
}

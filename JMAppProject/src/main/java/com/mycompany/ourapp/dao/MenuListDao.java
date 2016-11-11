package com.mycompany.ourapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


import com.mycompany.ourapp.dto.MenuList;


@Component
public class MenuListDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private MenuList menuList;
	
	public int insert(MenuList menuList){
		String sql="insert into menuList(mlname,mlprice,mlresid,mlinfo,mlsavedfile),values(?,?,?,?,?)";
		int row = jdbcTemplate.update(
				sql,
				menuList.getMlname(),
				menuList.getMlprice(),
				menuList.getMlResid(),
				menuList.getMlinfo(),
				menuList.getMlsavedfile()
				);
		return row;
	}
	
	public int modify(MenuList menuList){
		String sql="update menuList set mlname=?,mlprice=?,mlinfo=?,mlsavedfile=? where mlresid=?";
		int row = jdbcTemplate.update(
				sql,
				menuList.getMlname(),
				menuList.getMlprice(),
				menuList.getMlinfo(),
				menuList.getMlsavedfile(),
				menuList.getMlResid()
				);
		return row;
	}
	
	public int delete(int mlResid, String mlname){
		String sql="delete from menuList where mlResid=? and mlname=?";
		int row = jdbcTemplate.update(sql,mlResid,mlname);
		return row;
	}
	
	public List<MenuList> resHotList(int mlResid, boolean mlishot){
		String sql="select mlname from menuList where mlResid=? and mlishot=?";
		List<MenuList> list = jdbcTemplate.query(sql, new Object[]{mlResid,mlishot}, new RowMapper<MenuList>() {
			@Override
			public MenuList mapRow(ResultSet rs, int row) throws SQLException {
				MenuList menuList = new MenuList();
				menuList.setMlname(rs.getString("mlname"));
				menuList.setMlprice(rs.getInt("mlprice"));
				menuList.setMlResid(rs.getInt("mlresid"));
				menuList.setMlinfo(rs.getString("mlinfo"));
				menuList.setMlsavedfile(rs.getString("mlsavedfile"));
				
				return menuList;
			}
		});
		return list;
		
	}
	
	
	public int modifyHot(int mlResid,String mlname, boolean mlishot){
		String sql="update menuList set mlprice=?,mlinfo=?,mlsavedfile=? where mlresid=? and mlname=? and mlishot=true";
		int row = jdbcTemplate.update(
				sql,
				menuList.getMlprice(),
				menuList.getMlinfo(),
				menuList.getMlsavedfile(),
				menuList.getMlResid(),
				menuList.getMlname()
	               );
		return row;
	
	}
}
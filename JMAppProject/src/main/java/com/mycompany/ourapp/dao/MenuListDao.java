package com.mycompany.ourapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.mycompany.ourapp.dto.MenuList;

@Component
public class MenuListDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
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
		String sql="update menuList set mlname=?,mlprice=?,mlresid=?,mlinfo=?,mlsavedfile=?";
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
	
	public int delete(int mlResid, String mlname){
		String sql="delete from menuList where mlResid=?,mlname=?";
		int row = jdbcTemplate.update(sql,mlResid,mlname);
		return row;
	}
	
	public int select(int mlResid, boolean mlishot){
		String sql="select mlname from menuList where mlResid=?, mlishot=";
		int row = jdbcTemplate.update(sql,);
	}
}
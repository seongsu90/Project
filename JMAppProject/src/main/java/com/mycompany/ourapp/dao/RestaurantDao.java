package com.mycompany.ourapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.ourapp.dto.Restaurant;

@Component
public class RestaurantDao {

	@Autowired
	private static JdbcTemplate jdbcTemplate;
	
	public static int insert(Restaurant restaurant) {
		String sql="insert into Restaurant (resId, resname, reslocation, restotaltable, resinfo, restel, resopen, resclose, ressavedfile, closeday) values(?,?,?,?,?,?,?,?,?,?)";
		int row=jdbcTemplate.update(
				sql,
				restaurant.getResId(),
				restaurant.getResname(),
				restaurant.getReslocation(),
				restaurant.getRestotaltable(),
				restaurant.getResinfo(),
				restaurant.getRestel(),
				restaurant.getResopen(),
				restaurant.getResclose(),
				restaurant.getRessavedfile(),
				restaurant.getRescloseday()
				);
		return row;
	}

	public int delete(int resid) {
		String sql="delete from restaurant where resId=?";
		int row=jdbcTemplate.update(sql, resid);
		return row;
	}

	public int update(Restaurant restaurant) {
		String sql="update restaurant set resname=?, reslocation=?, restotaltable=?, resinfo=?, restel=?, resopen=?, resclose=?, ressavedfile=?, rescloseday=? where resid=?";
		int row=jdbcTemplate.update(
				sql,
				restaurant.getResname(),
				restaurant.getReslocation(),
				restaurant.getRestotaltable(),
				restaurant.getResinfo(),
				restaurant.getRestel(),
				restaurant.getResopen(),
				restaurant.getResclose(),
				restaurant.getRessavedfile(),
				restaurant.getRescloseday(),
				restaurant.getResId()
				
				);
		return row;
	}

	public Restaurant selectByResid(int resid) {
		String sql="select resId, resname, reslocation, restotaltable, resinfo, restel, resopen, resclose, ressavedfile, rescloseday from restaurant where resid=?";
		List<Restaurant> list=jdbcTemplate.query(sql, new Object[]{resid}, new RowMapper<Restaurant>(){
			@Override
			public Restaurant mapRow(ResultSet rs, int row) throws SQLException{
				Restaurant restaurant=new Restaurant();
				restaurant.setResId(rs.getInt("resid"));
				restaurant.setResname(rs.getString("resname"));
				restaurant.setReslocation(rs.getString("reslocation"));
				restaurant.setResinfo(rs.getString("resinfo"));
				restaurant.setRestel(rs.getString("restel"));
				restaurant.setRestotaltable(rs.getInt("restotaltable"));
				restaurant.setRescloseday(rs.getString("rescloseday"));
				restaurant.setResopen(rs.getTime("resopen"));
				restaurant.setResclose(rs.getTime("resclose"));
				restaurant.setRessavedfile(rs.getString("ressavedfile"));
				return restaurant;
			}
		});
		return (list.size()!=0)? list.get(0) : null;
	}
	
	
	
}

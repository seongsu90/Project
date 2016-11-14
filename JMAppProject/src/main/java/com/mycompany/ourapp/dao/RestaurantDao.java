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
	
	public int insert(Restaurant restaurant) {
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
	
	public List<Restaurant> selectByPage(int pageNo, int rowsPerPage){
		String sql="";
		sql+="select rn, resid, resname, resinfo, ressavedfile ";
		sql+="from( " ;
		sql+="select rownum as rn, resid, resname, resinfo, ressavedfile ";
		sql+="from (select resid, resname, resinfo, ressavedfile from Restaurant order by resid desc) ";
		sql+="where rownum<=? ";
		sql+=") ";
		sql+="where rn>=? ";
		
		List<Restaurant> list=jdbcTemplate.query(
				sql, 
				new Object[]{(pageNo*rowsPerPage),((pageNo-1)*rowsPerPage+1)},
				new RowMapper<Restaurant>(){
					@Override
					public Restaurant mapRow(ResultSet rs, int row)throws SQLException{
						Restaurant restaurant=new Restaurant();
						restaurant.setResId(rs.getInt("resid"));
						restaurant.setResname(rs.getString("resname"));
						restaurant.setResinfo(rs.getString("resinfo"));
						restaurant.setRessavedfile(rs.getString("ressavedfile"));
						
						return restaurant;
					}
				}
		);
	return list;
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

	public int count(){
		String sql="select count(*) from restaurant";
		int count=jdbcTemplate.queryForObject(sql, Integer.class);   
		return count;
	}

/*	public static int emptyTableNum(int resid) {
		String sql="select count (distinct ptableno) from Pos where resid=? ";
		jdbcTemplate.
		return ;
	}*/
	
	
	
}
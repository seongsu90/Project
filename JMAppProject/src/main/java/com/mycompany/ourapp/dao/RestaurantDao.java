package com.mycompany.ourapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.ourapp.dto.Restaurant;

@Component
public class RestaurantDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Restaurant restaurant) {
		String sql="insert into restaurant(resid, resname, reslocation, restotaltable, resinfo, restel, resopen, resclose, ressavedfile, rescloseday, resmime) values(seq_restaurant_resid.nextval,?,?,?,?,?,?,?,?,?,?)";
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
				restaurant.getResmime()
				);
		return row;
	}

	public int delete(int resid) {
		String sql="delete from restaurant where resid=?";
		int row=jdbcTemplate.update(sql, resid);
		return row;
	}

	public int update(Restaurant restaurant) {
		String sql="update restaurant set resname=?, reslocation=?, restotaltable=?, resinfo=?, restel=?, resopen=?, resclose=?, ressavedfile=?, rescloseday=?, resphoto=?, resmime=? where resid=?";
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
				restaurant.getResphoto(),
				restaurant.getResmime(),
				restaurant.getResid()
				
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
						restaurant.setResid(rs.getInt("resid"));
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
		String sql="select resid, resname, reslocation, restotaltable, resinfo, restel, rescloseday, resopen, resclose, ressavedfile, resmime from restaurant where resid=?";
		List<Restaurant> list=jdbcTemplate.query(sql, new Object[]{resid}, new RowMapper<Restaurant>(){
			@Override
			public Restaurant mapRow(ResultSet rs, int row) throws SQLException{
				Restaurant restaurant=new Restaurant();
				restaurant.setResid(rs.getInt("resid"));
				restaurant.setResname(rs.getString("resname"));
				restaurant.setReslocation(rs.getString("reslocation"));
				restaurant.setRestotaltable(rs.getInt("restotaltable"));
				restaurant.setResinfo(rs.getString("resinfo"));
				restaurant.setRestel(rs.getString("restel"));
				restaurant.setRescloseday(rs.getString("rescloseday"));
				restaurant.setResopen(rs.getString("resopen"));
				restaurant.setResclose(rs.getString("resclose"));
				restaurant.setRessavedfile(rs.getString("ressavedfile"));
				restaurant.setResmime(rs.getString("resmime"));
			
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

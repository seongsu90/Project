package com.mycompany.ourapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


import com.mycompany.ourapp.dto.Coupon;
import com.mycompany.ourapp.dto.CouponBox;
import com.mycompany.ourapp.dto.Reservation;

@Component
public class CouponDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Coupon coupon) {
		String sql = "insert into coupon(cnumber, cname, cdday, cinfo, cResid,cdiscount) values(?, ?, ?, ?, ?, ?)";
		int row = jdbcTemplate.update(
				sql,
				coupon.getCnumber(),
				coupon.getCname(),
				coupon.getCdday(),
				coupon.getCinfo(),
				coupon.getCResid(),
				coupon.getCdiscount()
		);		
		return row;
	}
	
	public int delete(int cnumber) {
		String sql = "delete from coupon where cnumber=?";
		int row = jdbcTemplate.update( sql, cnumber );		
		return row;
	}
	
	public int send(CouponBox couponBox)
	{
		String sql="insert into couponbox(cbMid,cbnumber) values(?,?)";
		int row = jdbcTemplate.update(
				sql,
				couponBox.getCbmid(),
				couponBox.getCbnumber()
		);		
		return row;
	}
	
	public Coupon selectById(int cnumber) {
		String sql = "select cnumber,cname,cdday,cinfo,cResid,cdiscount from coupon where cnumber=?";
		List<Coupon> list = jdbcTemplate.query(sql, new Object[]{cnumber}, new RowMapper<Coupon>() {
			@Override
			public Coupon mapRow(ResultSet rs, int row) throws SQLException {
				Coupon coupon = new Coupon();
				coupon.setCnumber(rs.getInt("cnumber"));
				coupon.setCname(rs.getString("cname"));
				coupon.setCdday(rs.getDate("cdday"));
				coupon.setCinfo(rs.getString("cinfo"));
				coupon.setCresid(rs.getInt("cResid"));
				coupon.setCdiscount(rs.getInt("cdiscount"));
				
				return coupon;
			}
		});
		return (list.size() != 0)?list.get(0) : null;
	}
}

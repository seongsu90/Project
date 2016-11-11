package com.mycompany.ourapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.ourapp.dao.CouponDao;
import com.mycompany.ourapp.dto.Coupon;
import com.mycompany.ourapp.dto.CouponBox;

@Component
public class CouponService {
	private static final int ADD_SUCCESS = 0;
	private static final int ADD_FAIL =1;
	
	private static final int SEND_SUCCESS = 0;
	private static final int SEND_FAIL = 1;
	
	private static final int DELETE_SUCCESS = 0;
	private static final int DELETE_FAIL = 1;
	
	@Autowired
	private CouponDao coupondao;
	
	public int add(Coupon coupon) {
		int row=coupondao.insert(coupon);
		if(row==0)
		{
			return ADD_FAIL;
		}
		return ADD_SUCCESS;
	}
	
	public int send(CouponBox couponBox) {	
		int row=coupondao.send(couponBox);
		if(row==0)
		{
			return SEND_FAIL;
		}
		return SEND_SUCCESS;
	}
	
	public int delete(int cnumber) {
		int row = coupondao.delete(cnumber);
		if(row==0)
		{
			return DELETE_FAIL;
		}
		return DELETE_SUCCESS;
	}
	
	public Coupon info(int cnumber) {
		Coupon coupon = new Coupon();
		return coupon;
	}
}

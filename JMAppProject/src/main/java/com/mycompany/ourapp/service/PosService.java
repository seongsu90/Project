package com.mycompany.ourapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.ourapp.dao.PosDao;
import com.mycompany.ourapp.dto.Coupon;
import com.mycompany.ourapp.dto.MenuList;
import com.mycompany.ourapp.dto.Pos;
import com.mycompany.ourapp.dto.Reservation;

@Component
public class PosService {
	
	public static final int ADD_SUCCESS = 0;
	public static final int ADD_FAIL =1;
	
	public static final int MODIFY_SUCCESS=0;
	public static final int MODIFY_FAIL=1;
	
	public static final int DELETE_SUCCESS = 0;
	public static final int DELETE_FAIL = 1;
	
	public static final int COUPON_SUCCESS = 0;
	public static final int COUPON_FAIL = 1;						// 쿠폰 조회 안됨
	public static final int COUPON_EXPIRE_DATE = 2;
	
	@Autowired
	private PosDao posDao;

	public int add(Pos pos) { 
		int row = posDao.insert(pos);	
		if(row == 0){
			return ADD_FAIL;
		}
		return ADD_SUCCESS;
	}

	public int modify(Pos pos) {
		int row = posDao.update(pos);
		if(row == 0){
			return MODIFY_FAIL;
		}
		return MODIFY_SUCCESS;
	}
	
	public int delete(int presid, int ptableno) {
		int row = posDao.delete(presid, ptableno);
		if(row == 0){
			return DELETE_FAIL;
		}
		return DELETE_SUCCESS;
	}
	
	public List<Pos> info(int presid, int ptableno) {
		List<Pos> list = posDao.selectInfo(presid, ptableno);
		return list;
	}
	
	public List<Integer> calcSum(int presid, int ptableno) {		
		List<Integer> list = posDao.calc(presid, ptableno);
		return list;
	}
	
	public List<Pos> list(int presid) {
		List<Pos> list = posDao.list(presid);
		return list; 
	}

	public List<MenuList> menuList(int presid) {
		List<MenuList> menuList = posDao.selectMenu(presid);
		return menuList;
	}

	public List<Reservation> reservList(int presid) {
		List<Reservation> list = posDao.reservList(presid);
		return list;
	}
	
	public int checkCoupon(String cbmid, int cbnumber) {		
		Coupon coupon = posDao.checkCoupon(cbmid, cbnumber);		
		Date now = new Date();		
		
		if (coupon == null) {
			return COUPON_FAIL;
		} else if (now.after(coupon.getCdday())) {		// 쿠폰 유효기간 확인
			return COUPON_EXPIRE_DATE;				
		} 	
		return coupon.getCdiscount();
	}
}


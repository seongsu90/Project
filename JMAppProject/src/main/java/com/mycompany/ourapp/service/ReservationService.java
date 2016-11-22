package com.mycompany.ourapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.ourapp.dao.ReservationDao;
import com.mycompany.ourapp.dto.Reservation;

@Component
public class ReservationService {
	private static final int ADD_SUCCESS = 0;
	private static final int ADD_FAIL =1;
	
	private static final int TIME_OUT=1;
	private static final int DAY_OUT=1;
	
	private static final int DELETE_SUCCESS = 0;
	private static final int DELETE_FAIL = 1;
	
	@Autowired
	private ReservationDao reservationDao;
	
	public int add(Reservation reservation) {
		int row = reservationDao.insert(reservation);
		return ADD_SUCCESS;
	}
	
	public int delete(String rvMid, int rvResid) {
		int row = reservationDao.delete(rvMid,rvResid);
		if(row==0)
		{
			return DELETE_FAIL;
		}
		return DELETE_SUCCESS;
	}
	
	public List<Reservation> list(String mid, int pageNo, int rowsPerPage){
		return reservationDao.selectByPage(mid,pageNo, rowsPerPage);
	}
	
	public Reservation info(String rvMid, int rvResid) {
		Reservation reservation = new Reservation();
		return reservation;
	}
	
	
	public int getCount(){
		return reservationDao.count();
	}
	

}

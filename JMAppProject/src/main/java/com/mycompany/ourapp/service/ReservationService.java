package com.mycompany.ourapp.service;

import com.mycompany.ourapp.dto.Reservation;

public class ReservationService {
	public int add(Reservation reservation) {
		
		return SUCCESS;
	}
	
	public int delete(String rvMid, int rvResid) {
		
		return SUCCESS;
	}
	
	public Reservation info(String rvMid, int rvResid) {
		
		Reservation reservation = new Reservation();
		
		return reservation;
	}
}

package com.mycompany.ourapp.dto;

import java.util.Date;

public class Reservation {
	private int rvno;
	private Date rvtime;
	private int rvperson;
	private String rvMid;
	private int rvResid;
	
	public int getRvno() {
		return rvno;
	}
	public void setRvno(int rvno) {
		this.rvno = rvno;
	}
	public Date getRvtime() {
		return rvtime;
	}
	public void setRvtime(Date rvtime) {
		this.rvtime = rvtime;
	}
	public int getRvperson() {
		return rvperson;
	}
	public void setRvperson(int rvperson) {
		this.rvperson = rvperson;
	}
	public String getRvMid() {
		return rvMid;
	}
	public void setRvMid(String rvMid) {
		this.rvMid = rvMid;
	}
	public int getRvResid() {
		return rvResid;
	}
	public void setRvResid(int rvResid) {
		this.rvResid = rvResid;
	}
	
	
}

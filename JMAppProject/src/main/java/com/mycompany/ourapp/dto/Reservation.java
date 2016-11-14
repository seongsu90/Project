package com.mycompany.ourapp.dto;

import java.util.Date;

public class Reservation {

	private Date rvtime;
	private int rvperson;
	private String rvmid;
	private int rvresid;
	
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
	public String getRvmid() {
		return rvmid;
	}
	public void setRvmid(String rvmid) {
		this.rvmid = rvmid;
	}
	public int getRvresid() {
		return rvresid;
	}
	public void setRvresid(int rvresid) {
		this.rvresid = rvresid;
	}

	
	
	
}

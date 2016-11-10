package com.mycompany.ourapp.dto;

import java.util.Date;

public class Member {
	private String mid;
	private String mname;
	private String mpassword;
	private String mphone;
	private Date mbirth;
	private String mlocation;
	private int mrank;
	private int mpoint;
	private int mresid;
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public Date getMbirth() {
		return mbirth;
	}
	public void setMbirth(Date mbirth) {
		this.mbirth = mbirth;
	}
	public String getMlocation() {
		return mlocation;
	}
	public void setMlocation(String mlocation) {
		this.mlocation = mlocation;
	}
	public int getMrank() {
		return mrank;
	}
	public void setMrank(int mrank) {
		this.mrank = mrank;
	}
	public int getMpoint() {
		return mpoint;
	}
	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}
	public int getMresid() {
		return mresid;
	}
	public void setMresid(int mresid) {
		this.mresid = mresid;
	}

}

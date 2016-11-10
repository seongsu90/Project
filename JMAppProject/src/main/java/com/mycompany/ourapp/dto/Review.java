package com.mycompany.ourapp.dto;

import java.sql.Date;

public class Review {
	private int revno;
	private int revResid;
	private String revMid;
	private String revcontent;
	private int revscore;
	private Date revdate;
	
	public int getRevno() {
		return revno;
	}
	public void setRevno(int revno) {
		this.revno = revno;
	}
	public int getRevResid() {
		return revResid;
	}
	public void setRevResid(int revResid) {
		this.revResid = revResid;
	}
	public String getRevMid() {
		return revMid;
	}
	public void setRevMid(String revMid) {
		this.revMid = revMid;
	}
	public String getRevcontent() {
		return revcontent;
	}
	public void setRevcontent(String revcontent) {
		this.revcontent = revcontent;
	}
	public int getRevscore() {
		return revscore;
	}
	public void setRevscore(int revscore) {
		this.revscore = revscore;
	}
	public Date getRevdate() {
		return revdate;
	}
	public void setRevdate(Date revdate) {
		this.revdate = revdate;
	}
}

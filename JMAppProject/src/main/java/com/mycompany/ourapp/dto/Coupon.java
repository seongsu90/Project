package com.mycompany.ourapp.dto;

import java.util.Date;

public class Coupon {
	private int cnumber;
	private String cname;
	private Date cdday;
	private String cinfo;
	private int cResid;
	private int cdiscount;
	
	public int getCnumber() {
		return cnumber;
	}
	public void setCnumber(int cnumber) {
		this.cnumber = cnumber;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Date getCdday() {
		return cdday;
	}
	public void setCdday(Date cdday) {
		this.cdday = cdday;
	}
	public String getCinfo() {
		return cinfo;
	}
	public void setCinfo(String cinfo) {
		this.cinfo = cinfo;
	}
	public int getCResid() {
		return cResid;
	}
	public void setCresid(int cResid) {
		this.cResid = cResid;
	}
	public int getcResid() {
		return cResid;
	}
	public void setcResid(int cResid) {
		this.cResid = cResid;
	}
	public int getCdiscount() {
		return cdiscount;
	}
	public void setCdiscount(int cdiscount) {
		this.cdiscount = cdiscount;
	}
	}

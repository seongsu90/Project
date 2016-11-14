package com.mycompany.ourapp.dto;

import java.util.Date;

public class Event {
	private String ename; 
	private int eresid;
	private String esavedfile;
	private String einfo;
	private String emlname;
	private int eprice;
	private Date estart;
	private Date eend;
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEresid() {
		return eresid;
	}
	public void setEresid(int eresid) {
		this.eresid = eresid;
	}
	public String getEsavedfile() {
		return esavedfile;
	}
	public void setEsavedfile(String esavedfile) {
		this.esavedfile = esavedfile;
	}
	public String getEinfo() {
		return einfo;
	}
	public void setEinfo(String einfo) {
		this.einfo = einfo;
	}
	public String getEmlname() {
		return emlname;
	}
	public void setEmlname(String emlname) {
		this.emlname = emlname;
	}
	public int getEprice() {
		return eprice;
	}
	public void setEprice(int eprice) {
		this.eprice = eprice;
	}
	public Date getEstart() {
		return estart;
	}
	public void setEstart(Date estart) {
		this.estart = estart;
	}
	public Date getEend() {
		return eend;
	}
	public void setEend(Date eend) {
		this.eend = eend;
	}
	
	
}

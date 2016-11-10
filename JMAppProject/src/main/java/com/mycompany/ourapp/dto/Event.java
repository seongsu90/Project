package com.mycompany.ourapp.dto;

import java.util.Date;

public class Event {
	private String ename;
	private int eResid;
	private String esavedfile;
	private String einfo;
	private String eMlname;
	private int eprice;
	private Date estar;
	private Date eend;
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int geteResid() {
		return eResid;
	}
	public void seteResid(int eResid) {
		this.eResid = eResid;
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
	public String geteMlname() {
		return eMlname;
	}
	public void seteMlname(String eMlname) {
		this.eMlname = eMlname;
	}
	public int getEprice() {
		return eprice;
	}
	public void setEprice(int eprice) {
		this.eprice = eprice;
	}
	public Date getEstar() {
		return estar;
	}
	public void setEstar(Date estar) {
		this.estar = estar;
	}
	public Date getEend() {
		return eend;
	}
	public void setEend(Date eend) {
		this.eend = eend;
	}
	
	
}

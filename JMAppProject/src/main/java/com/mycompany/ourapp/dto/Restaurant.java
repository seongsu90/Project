package com.mycompany.ourapp.dto;

import java.util.Date;

public class Restaurant {
	private int resId;
	private String resname;
	private String reslocation;
	private int restotaltable;
	private String resinfo;
	private String restel;
	private Date resopen;
	private Date resclose;
	private String ressavedfile;
	
	public int getResId() {
		return resId;
	}
	public void setResId(int resId) {
		this.resId = resId;
	}
	public String getResname() {
		return resname;
	}
	public void setResname(String resname) {
		this.resname = resname;
	}
	public String getReslocation() {
		return reslocation;
	}
	public void setReslocation(String reslocation) {
		this.reslocation = reslocation;
	}
	public int getRestotaltable() {
		return restotaltable;
	}
	public void setRestotaltable(int restotaltable) {
		this.restotaltable = restotaltable;
	}
	public String getResinfo() {
		return resinfo;
	}
	public void setResinfo(String resinfo) {
		this.resinfo = resinfo;
	}
	public String getRestel() {
		return restel;
	}
	public void setRestel(String restel) {
		this.restel = restel;
	}
	public Date getResopen() {
		return resopen;
	}
	public void setResopen(Date resopen) {
		this.resopen = resopen;
	}
	public Date getResclose() {
		return resclose;
	}
	public void setResclose(Date resclose) {
		this.resclose = resclose;
	}
	public String getRessavedfile() {
		return ressavedfile;
	}
	public void setRessavedfile(String ressavedfile) {
		this.ressavedfile = ressavedfile;
	}
	
	
	
}

package com.mycompany.ourapp.dto;

import java.sql.Time;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Restaurant {
	private int resid;
	private String resname;
	private String reslocation;
	private int restotaltable;
	private String resinfo;
	private String restel;
	private String rescloseday;
	private Time resopen;
	private Time resclose;
	private MultipartFile ressavedfile;
	
	public int getResid() {
		return resid;
	}
	public void setResid(int resid) {
		this.resid = resid;
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
	public Time getResopen() {
		return resopen;
	}
	public void setResopen(Time resopen) {
		this.resopen = resopen;
	}
	public Time getResclose() {
		return resclose;
	}
	public void setResclose(Time resclose) {
		this.resclose = resclose;
	}
	public MultipartFile getRessavedfile() {
		return ressavedfile;
	}
	public void setRessavedfile(MultipartFile ressavedfile) {
		this.ressavedfile = ressavedfile;
	}
	public String getRescloseday() {
		return rescloseday;
	}
	public void setRescloseday(String rescloseday) {
		this.rescloseday = rescloseday;
	}
	
}

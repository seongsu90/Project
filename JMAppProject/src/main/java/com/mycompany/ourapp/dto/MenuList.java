package com.mycompany.ourapp.dto;
public class MenuList {
	private String mlname;
	private int mlprice;
	private int mlResid;
	private String mlinfo;
	private String mlsavedfile;
	private boolean mlisshot;
	
	public String getMlname() {
		return mlname;
	}
	public void setMlname(String mlname) {
		this.mlname = mlname;
	}
	public int getMlprice() {
		return mlprice;
	}
	public void setMlprice(int mlprice) {
		this.mlprice = mlprice;
	}
	public int getMlResid() {
		return mlResid;
	}
	public void setMlResid(int mlResid) {
		this.mlResid = mlResid;
	}
	public String getMlinfo() {
		return mlinfo;
	}
	public void setMlinfo(String mlinfo) {
		this.mlinfo = mlinfo;
	}
	public String getMlsavedfile() {
		return mlsavedfile;
	}
	public void setMlsavedfile(String mlsavedfile) {
		this.mlsavedfile = mlsavedfile;
	}
	public boolean isMlisshot() {
		return mlisshot;
	}
	public void setMlisshot(boolean mlisshot) {
		this.mlisshot = mlisshot;
	}
	
	
}

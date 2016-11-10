package com.mycompany.ourapp.dto;

public class Pos {
	private int ptableno;
	private int pResid;
	private String pMlname;
	private int pcount;
	
	public int getPtableno() {
		return ptableno;
	}
	public void setPtableno(int ptableno) {
		this.ptableno = ptableno;
	}
	public int getpResid() {
		return pResid;
	}
	public void setpResid(int pResid) {
		this.pResid = pResid;
	}

	public String getpMlname() {
		return pMlname;
	}
	public void setpMlname(String pMlname) {
		this.pMlname = pMlname;
	}
	public int getPcount() {
		return pcount;
	}
	public void setPcount(int pcount) {
		this.pcount = pcount;
	}
}

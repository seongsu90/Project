package com.mycompany.ourapp.service;

import com.mycompany.ourapp.dto.Member;

class MemberService {
	
	public int join(Member member) {
		return 0;
	}
	
	public int login(String mid, String password) {
		return 0;
	}
	
	public int logout(String mid) {
		return 0;
	}
	
	public String findMid(String mname, String mphone) {
		return null;
	}
	
	public String findMpassword(String mid, String mphone) {
		return null;
	}
	
	public Member info(String mid, String mpassword) {
		Member member = new Member();
		return member;
	}
	
	public int modify(Member member) {
		return 0;
	}
	
	public int withdraw(String mid, String mpassword) {
		return 0;
	}
	
	public boolean isMid(String mid) {
		return true;
	}	
}
	
package com.mycompany.myweb2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb2.dao.MemberDao;
import com.mycompany.myweb2.dto.Member;



@Component
public class MemberService {
	public static final int JOIN_SUCCESS = 0;
	public static final int JOIN_FAIL = 1;
	
	public static final int LOGIN_SUCCESS = 0;
	public static final int LOGIN_FAIL_MID = 1;
	public static final int LOGIN_FAIL_MPASSWORD = 2;
	
	public static final int LOGOUT_SUCCESS = 0;
	public static final int LOGOUT_FAIL = 1;
	
	public static final int MODIFY_SUCCESS = 0;
	public static final int MODIFY_FAIL = 1;
	
	public static final int WITHDRAW_SUCCESS = 0;
	public static final int WITHDRAW_FAIL = 1;
	
	@Autowired
	private MemberDao memberDao;
	
	public int join(Member member) {
		memberDao.insert(member);
		return JOIN_SUCCESS;
	}
	
	public int login(String mid, String mpassword) {
		Member member = memberDao.selectByMid(mid);
		if ( member == null ) return LOGIN_FAIL_MID;
		if ( member.getMpassword().equals(mpassword) == false ) return LOGIN_FAIL_MPASSWORD;
		return LOGIN_SUCCESS;
	}
	
	public int logout(String mid) {
		return LOGOUT_SUCCESS;		
	}
	
	public String findMPassword(String mid, String memail) {
		Member member = memberDao.selectByMid(mid);
		if ( member == null ){ return null;}
		if ( member.getMemail().equals(memail) == false ) return null;
		return member.getMpassword();
	}
	
	public String findMid(String memail) {
		return memberDao.selectByMemail(memail);
	}
	
	public Member info(String mid,String mpassword) {
		Member member = memberDao.selectByMid(mid);
		if ( member.getMpassword().equals(mpassword) == false ) return null;
		return member;
	}
	
	public int modify(Member member) {
		Member dbMember = memberDao.selectByMid(member.getMid());
		if(dbMember.getMpassword().equals(member.getMpassword())==false){
			return MODIFY_FAIL;
		}
		int row = memberDao.update(member);
		if(row!=1)
		{
			return MODIFY_FAIL;
		}
		return MODIFY_SUCCESS;
	}
	
	public int withdraw(String mid,String mpassword) {
		Member member = memberDao.selectByMid(mid);
		if ( member.getMpassword().equals(mpassword) == false ) return WITHDRAW_FAIL;
		memberDao.delete(mid);
		logout(mid);
		return WITHDRAW_SUCCESS;
	}
	
	public boolean isMid(String mid) {
		Member member = memberDao.selectByMid(mid);
		if ( member == null ) return false;
		return true;	
	}

}

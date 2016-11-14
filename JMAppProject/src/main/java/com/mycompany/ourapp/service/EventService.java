package com.mycompany.ourapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.ourapp.dao.EventDao;
import com.mycompany.ourapp.dto.Event;

@Component
public class EventService {
	public static final int ADD_SUCCESS=0;
	public static final int ADD_FAIL=1;
	public static final int DELETE_SUCCESS=0;
	public static final int DELETE_FAIL=1;
	public static final int MODIFY_SUCCESS=0;
	public static final int MODIFY_FAIL=1;
	
	@Autowired
	private EventDao eventdao;
	
	public int add(Event event){
		int row = eventdao.insert(event);
		return ADD_SUCCESS;
	}
	
	public int delete(int eresid,String emlname){
		int row = eventdao.delete(eresid, emlname);
		if(row==0){return DELETE_FAIL;}
		return DELETE_SUCCESS;
	}
	
	public int modify(Event event){
		int row = eventdao.update(event);
		if(row==0){return MODIFY_FAIL;}
		return  MODIFY_SUCCESS;
	}
	
	public Event info(int eresid, String emlname){
		return eventdao.selectByEresidAndEmlname(eresid,emlname);
	}
}
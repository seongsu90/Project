package com.mycompany.ourapp.service;

import com.mycompany.ourapp.dto.Event;

public class EventService {
	public int create(Event event){
		return SUCCESS;
	}
	
	public int delete(String ename){
		return SUCCESS;
	}
	
	public int modify(Event event){
		Event event = new Event();
		return event;
	}
}
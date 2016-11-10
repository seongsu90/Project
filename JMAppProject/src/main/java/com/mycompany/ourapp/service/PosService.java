package com.mycompany.ourapp.service;

import com.mycompany.ourapp.dto.Pos;

public class PosService {
	
	public Pos info(int presid){
		Pos pos = new Pos();
		return pos;
	}
	
	public int modify(Pos pos){
		return MODIFY_SUCCESS;
	}
	
	public int add(int presid, String pmlname){
		return ADD_SUCCESS;
	}
	
	public int delete(int ptableno){
		return DELETE_SUCCESS;
	}
	
	public int nowTable(int presid){
		return 0;
	}
}
package com.mycompany.ourapp.service;

import com.mycompany.ourapp.dto.Pos;

public class PosService {
	
	public Pos info(int pResid,int ptableno){
		Pos pos = new Pos();
		return pos;
	}
	
	public int calcSum(Pos pos)
	{
		int result=0;
		return result;
	}
	
	public int modify(Pos pos){
		return 0;
	}
	
	public int add(Pos pos){ //테이블에 손님이 올때
		return 0;
	}
	
	public int delete(int pResid,int ptableno){
		return 0;
	}
	

}
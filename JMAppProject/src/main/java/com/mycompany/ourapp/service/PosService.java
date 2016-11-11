package com.mycompany.ourapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.ourapp.dao.PosDao;
import com.mycompany.ourapp.dto.Pos;

@Component
public class PosService {
	
	public static final int ADD_SUCCESS = 0;
	public static final int ADD_FAIL =1;
	
	public static final int MODIFY_SUCCESS=0;
	public static final int MODIFY_FAIL=1;
	
	public static final int DELETE_SUCCESS = 0;
	public static final int DELETE_FAIL = 1;
	
	@Autowired
	private PosDao posDao;

	public int add(Pos pos) { 
		int row = posDao.insert(pos);	
		if(row==0){
			return ADD_FAIL;
		}
		return ADD_SUCCESS;
	}

	public int modify(Pos pos) {
		int row = posDao.update(pos);
		if(row==0){
			return MODIFY_FAIL;
		}
		return MODIFY_SUCCESS;
	}
	
	public int delete(int ptableno, int pResid) {
		int row = posDao.delete(ptableno, pResid);
		if(row==0){
			return DELETE_FAIL;
		}
		return DELETE_SUCCESS;
	}
	
	public Pos info(int ptableno, int pResid) {
		Pos pos = posDao.selectInfo(ptableno, pResid);
		return pos;
	}
	
	public List<Integer> calcSum(int ptableno, int pResid) {		
		List<Integer> list = posDao.calc(ptableno, pResid);
		return list;
	}
}


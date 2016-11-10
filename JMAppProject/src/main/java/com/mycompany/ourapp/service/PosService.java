package com.mycompany.ourapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.ourapp.dao.PosDao;
import com.mycompany.ourapp.dto.Pos;

public class PosService {
	
	@Autowired
	private PosDao posDao;

	public int add(Pos pos) { 
		int row = posDao.insert(pos);				
		return row;
	}

	public int modify(Pos pos) {
		int row = posDao.update(pos);
		return row;
	}
	
	public int delete(int ptableno, int pResid) {
		int row = posDao.delete(ptableno, pResid);
		return row;
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


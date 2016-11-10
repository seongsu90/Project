package com.mycompany.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.FreeBoardDao;
import com.mycompany.myweb.dto.FreeBoard;

@Component
public class FreeBoardService {
	public static final int WRITE_SUCCESS=0;
	public static final int WRITE_FAIL=1;
	
	public static final int MODIFY_SUCCESS=0;
	public static final int MODIFY_FAIL=1;
	
	public static final int REMOVE_SUCCESS=0;
	public static final int REMOVE_FAIL=1;
	
	@Autowired
	private FreeBoardDao freeBoardDao;
	
	public List<FreeBoard> list(int pageNo, int rowsPerPage){
		return freeBoardDao.selectByPage(pageNo, rowsPerPage);
	}
	public int write(FreeBoard freeboard){
		int row=freeBoardDao.insert(freeboard);
		return WRITE_SUCCESS;
	}
	public int modify(FreeBoard freeboard){
		int row=freeBoardDao.update(freeboard);
		if(row==0){return MODIFY_FAIL;}
		return MODIFY_SUCCESS;
	}
	public int remove(int bno){
		int row = freeBoardDao.delete(bno);
		if(row==0){return REMOVE_FAIL;}
		return REMOVE_SUCCESS;
	}
	public FreeBoard info(int bno){
		return freeBoardDao.selectByBno(bno);
	}
	
	public int getCount()
	{
		return freeBoardDao.count();
	}
	
}

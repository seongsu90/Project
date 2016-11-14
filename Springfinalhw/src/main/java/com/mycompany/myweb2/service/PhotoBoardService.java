package com.mycompany.myweb2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb2.dao.PhotoBoardDao;
import com.mycompany.myweb2.dto.PhotoBoard;



@Component
public class PhotoBoardService {
	private static final int WRITE_SUCCESS=0;
	private static final int WRITE_FAIL=1;
	
	private static final int MODIFY_SUCCESS=0;
	private static final int MODIFY_FAIL=1;
	
	private static final int REMOVE_SUCCESS=0;
	private static final int REMOVE_FAIL=1;
	
	@Autowired
	private PhotoBoardDao photeBoardDao;
	
	public List<PhotoBoard> list(int pageNo, int rowsPerPage){
		return photeBoardDao.selectByPage(pageNo, rowsPerPage);
	}
	public int write(PhotoBoard photeboard){
		int row=photeBoardDao.insert(photeboard);
		return WRITE_SUCCESS;
	}
	public int modify(PhotoBoard photeboard){
		int row=photeBoardDao.update(photeboard);
		if(row==0){return MODIFY_FAIL;}
		return MODIFY_SUCCESS;
	}
	public int remove(int bno){
		int row = photeBoardDao.delete(bno);
		if(row==0){return REMOVE_FAIL;}
		return REMOVE_SUCCESS;
	}
	public PhotoBoard info(int bno){
		return photeBoardDao.selectByBno(bno);
	}
	
	public int getCount()
	{
		return photeBoardDao.count();
	}
	
}

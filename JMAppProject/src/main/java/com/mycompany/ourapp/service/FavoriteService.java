package com.mycompany.ourapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.ourapp.dao.FavoriteDao;

@Component
public class FavoriteService {
	
	@Autowired
	private FavoriteDao favoriteDao;
	
	public int add(String fMid, int fResid) {
		int result = favoriteDao.insert(fMid, fResid);
		return result;	
	}
	
	public int delete(String fMid, int fResid) {
		int result = favoriteDao.delete(fMid, fResid);
		return result;	
	}
}

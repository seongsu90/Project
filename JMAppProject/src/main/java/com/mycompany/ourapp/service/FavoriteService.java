package com.mycompany.ourapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.ourapp.dao.FavoriteDao;

@Component
public class FavoriteService {
	
	@Autowired
	private FavoriteDao favoriteDao;
	
	public int add(String fmid, int fresid) {
		int result = favoriteDao.insert(fmid, fresid);
		return result;	
	}
	
	public int delete(String fmid, int fresid) {
		int result = favoriteDao.delete(fmid, fresid);
		return result;	
	}
}

package com.mycompany.ourapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.ourapp.dao.FavoriteDao;
import com.mycompany.ourapp.dao.RestaurantDao;
import com.mycompany.ourapp.dto.Restaurant;

@Component
public class FavoriteService {
	
	@Autowired
	private FavoriteDao favoriteDao;
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	public int add(String fmid, int fresid) {
		int result = favoriteDao.insert(fmid, fresid);
		return result;	
	}
	
	public int delete(String fmid, int fresid) {
		int result = favoriteDao.delete(fmid, fresid);
		return result;	
	}
	
	public List<Restaurant> list(String fmid) {
		List<Integer> residList = favoriteDao.selectByFmid(fmid);
		//List<Restaurant> resList = new ArrayList<>();
		System.out.println(residList.get(0));
		System.out.println(residList.get(1));
		Restaurant res = restaurantDao.selectByResid(1);
		System.out.println(res.getResid());
		System.out.println(res.getResname());
//		for ( int i = 0 ; i < residList.size() ; i++ ) {
//			resList.add( restaurantDao.selectByResid(residList.get(i)) );
//		}
		return null;
	}
}

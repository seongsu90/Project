package com.mycompany.ourapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.ourapp.dao.RestaurantDao;
import com.mycompany.ourapp.dto.Restaurant;

@Component
public class RestaurantService {
	public static final int ADD_SUCCESS=0;
	public static final int ADD_FAIL=1;
	
	public static final int REMOVE_SUCCESS=0;
	public static final int REMOVE_FAIL=1;
	
	public static final int MODIFY_SUCCESS=0;
	public static final int MODIFY_FAIL=1;

	
@Autowired
private RestaurantDao restaurantDao;  

		public int add(Restaurant restaurant){
			restaurantDao.insert(restaurant);
			return ADD_SUCCESS;
		}
			
		public int delete(int resid){
			int row=restaurantDao.delete(resid);
			if(row==0){return REMOVE_FAIL;}
			return REMOVE_SUCCESS;
		}
		
		public int modify(Restaurant restaurant){
			int row=restaurantDao.update(restaurant);
			if(row==0){return MODIFY_FAIL;}
			return MODIFY_SUCCESS;
		}
		
		public Restaurant info(int resid){
			return restaurantDao.selectByResid(resid);
		}
		
		/*public int nowTable(int resid){
			int emptyTable=RestaurantDao.emptyTableNum(resid);
			return emptyTable;}*/
			
		
		
		
}


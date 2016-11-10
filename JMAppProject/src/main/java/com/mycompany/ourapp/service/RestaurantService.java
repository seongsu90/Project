package com.mycompany.ourapp.service;

import com.mycompany.ourapp.dto.Restaurant;

public class RestaurantService {

		public int add(Restaurant restaurant){
			return SUCCESS;
		}
			
		public int delete(int resid){
			return SUCCESS;
		}
		
		public int modify(Restaurant restaurant){
			return restaurant;
		}
		
		public Restaurant info(Restaurant restaurant){
			Restaurant restaurant = new Restaurant();
			return restaurant;
		}
		
}


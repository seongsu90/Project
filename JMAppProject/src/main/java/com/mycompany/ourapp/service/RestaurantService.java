package com.mycompany.ourapp.service;

import com.mycompany.ourapp.dto.Restaurant;

public class RestaurantService {

		public int add(Restaurant restaurant){
			return SUCCESS;
		}
			
		public int delete(int resid){
			return SUCCESS;
		}
		
		public Restaurant modify(Restaurant restaurant){
			return restaurant;
		}
		
		public Restaurant info(int resid){
			
			return restaurant;
		}
		
		public int nowTable(int Resid){
			return 0;
		}
}


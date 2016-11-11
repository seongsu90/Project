package com.mycompany.ourapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.ourapp.dto.Restaurant;
import com.mycompany.ourapp.service.RestaurantService;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantservice;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(Restaurant restaurant){
		return "restaurant/add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add("")
	
	

}

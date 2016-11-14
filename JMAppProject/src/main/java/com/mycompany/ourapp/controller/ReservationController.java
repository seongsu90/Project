package com.mycompany.ourapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.ourapp.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	private ReservationService reservationservice;
	
	@RequestMapping("/index")
	public String index()
	{
		logger.info("index 처리 요청");
		return "/reservation/index";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addForm(){
		return "/reservation/addForm";
	}
	
}

package com.mycompany.ourapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.ourapp.dto.Reservation;
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
		logger.info("addform 처리");
		return "/reservation/addform";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Reservation reservation){
		logger.info("add 처리");
		reservationservice.add(reservation);
		return "redirect:/reservation/index";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteform()
	{
		logger.info("deleteform 처리");
		return "/reservation/deleteform";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete (String rvMid, int rvResid)
	{
		reservationservice.delete(rvMid, rvResid);
		return "redirect:/reservation/index";
	}
	
}

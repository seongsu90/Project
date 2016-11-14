package com.mycompany.ourapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.ourapp.dto.Coupon;
import com.mycompany.ourapp.service.CouponService;



@Controller
@RequestMapping("/coupon")
public class CouponController {
	private static final Logger logger = LoggerFactory.getLogger(CouponController.class);
	
	@Autowired
	private CouponService couponservice;
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 처리요청");
		return "/coupon/index";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addform(){
		logger.info("add 요청처리");
		return "/coupon/addform";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(Coupon coupon){
		couponservice.add(coupon);
		logger.info("add 요청처리");
		return "redirect:/coupon/index";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteForm(){
		logger.info("deleteForm 처리");
		return "/coupon/deleteForm";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(int cnumber){
		logger.info("delete 처리");
		couponservice.delete(cnumber);
		return "redirect:/coupon/index";
	}
	
	@RequestMapping("/info")
	public String info(int cnumber, Model model)
	{
		logger.info("info 처리 요청");
		Coupon coupon = couponservice.info(cnumber);
		model.addAttribute("coupon",coupon);
		return "/coupon/info";
	}
}

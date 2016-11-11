package com.mycompany.ourapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("/add")
	public String add(){
		logger.info("add 요청처리");i
		return "/coupon/addform";
	}
}

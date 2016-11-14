package com.mycompany.ourapp.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.ourapp.dto.Coupon;
import com.mycompany.ourapp.dto.Member;
import com.mycompany.ourapp.service.CouponService;
import com.mycompany.ourapp.service.MemberService;



@Controller
@RequestMapping("/coupon")
public class CouponController {
	private static final Logger logger = LoggerFactory.getLogger(CouponController.class);
	
	private String mid=null;
	
	@Autowired
	private CouponService couponservice;
	
	@Autowired
	private MemberService memberservice;
	
	
	@RequestMapping("/index")
	public String index(String mid){
		this.mid = mid;
		logger.info("index 처리요청");
		return "/coupon/index";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addform(HttpSession session){
		logger.info("add 요청처리");
		int cnumber=0;
		int ranNum =0;
		boolean chkNum = false;
		int cresid = 0;
		for(;;)
		{
			if(chkNum!=true)
			{
			ranNum =(int)(Math.random()*100000000)+1;
			chkNum = couponservice.check(ranNum);
			}
			cnumber = ranNum;
			Member member = memberservice.info(mid);
			cresid = member.getMResid();
			break;
		}
		session.setAttribute("cresid", cresid);
		session.setAttribute("cnumber", cnumber);
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
	public String delete(int cnumber,Model model){
		logger.info("delete 처리");
		int result = couponservice.delete(cnumber);
		if(result == CouponService.DELETE_FAIL)
		{
			model.addAttribute("error", "DELETE_FAIL");
			return "/coupon/deleteForm";
		}
		model.addAttribute("success", "DELETE_SUCCESS");
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

package com.mycompany.ourapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping("/list")
	public String list(String pageNo,Model model,HttpSession session){
		int intPageNo =1;
		if(pageNo==null)
		{
			pageNo = (String) session.getAttribute("pageNo");
			if(pageNo != null) //넘어오지도 않고 세션에 존재하지도 않을 때는 1페이를 넘겨주게끔 셋팅
				{
					intPageNo =Integer.parseInt(pageNo)	;
				}
		}else
		{
			intPageNo = Integer.parseInt(pageNo);
		}
		session.setAttribute("pageNo", String.valueOf(intPageNo));
		
		int rowsPerPage = 8;
		int pagesPerGroup =5;
		
		int totalBoardNo = reservationservice.getCount();
		
		int totalPageNo = totalBoardNo/rowsPerPage + ((totalBoardNo%rowsPerPage!=0)?1:0); //나머지가 있다면 1을 더하고 없으면 0을 더한다.
		int totalGroupNo = (totalPageNo/pagesPerGroup)+((totalPageNo%pagesPerGroup!=0)?1:0);
		
		int groupNo = (intPageNo-1)/ pagesPerGroup +1;
		int startPageNo = (groupNo-1)*pagesPerGroup +1;
		int endPageNo = startPageNo + pagesPerGroup -1;
		
		if(groupNo==totalGroupNo){endPageNo= totalPageNo;}
		
		List<Reservation> list = reservationservice.list(intPageNo, rowsPerPage);
		model.addAttribute("pageNo",intPageNo);
		model.addAttribute("rowsPerPage",rowsPerPage);
		model.addAttribute("pagesPerGroup",pagesPerGroup);
		model.addAttribute("totalPageNo",totalPageNo);
		model.addAttribute("totalBoardNo",totalBoardNo);
		model.addAttribute("totalGroupNo",totalGroupNo);
		model.addAttribute("groupNo",groupNo);
		model.addAttribute("startPageNo",startPageNo);
		model.addAttribute("endPageNo",endPageNo);
		model.addAttribute("list",list);
		return "reservation/list";
	}
	
}

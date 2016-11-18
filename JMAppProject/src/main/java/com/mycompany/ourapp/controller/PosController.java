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

import com.mycompany.ourapp.dto.Member;
import com.mycompany.ourapp.dto.Pos;
import com.mycompany.ourapp.dto.Restaurant;
import com.mycompany.ourapp.service.MemberService;
import com.mycompany.ourapp.service.MenuListService;
import com.mycompany.ourapp.service.PosService;
import com.mycompany.ourapp.service.RestaurantService;

@Controller
@RequestMapping("/pos")
public class PosController {
	private static final Logger logger = LoggerFactory.getLogger(PosController.class);
	
	@Autowired
	private PosService posService;
	
	@Autowired
	private MemberService memberService;
		
	@Autowired
	private MenuListService menuListService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping("/index")
	public String index(HttpSession session, Model model) {
		logger.info("pos index");
		String mid = (String) session.getAttribute("login");		// 로그인 mid 찾아서 mresid 확인
		Member member = memberService.info(mid);
		int presid = member.getMresid();
		List<Pos> posList = posService.list(presid);
		
		Restaurant restaurant = restaurantService.info(presid);
		int totalTable = restaurant.getRestotaltable();
		
		session.setAttribute("presid", presid);
		model.addAttribute("posList", posList);
		model.addAttribute("totalTable", totalTable);
		return "pos/index";
	}

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addForm() {
		logger.info("pos addForm 실행");
		
		return "pos/addForm";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(Pos pos) {		// 수기 주문, 모바일 주문
		logger.info("pos add 실행");		
		posService.add(pos);		
		return "redirect:/pos/index";	
	}

	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyForm() {
		logger.info("pos modifyForm 실행");
		return "pos/modifyForm";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(Pos pos) {
		logger.info("pos modify 실행");
		posService.modify(pos);
		return "redirect:/pos/index";
	}
	
	@RequestMapping("/delete")
	public String delete(int presid, int ptableno) {
		logger.info("pos delete 실행");
		int row = posService.delete(presid, ptableno);
		return "redirect:/pos/index";	
	}
	
	@RequestMapping("/info")	
	public String info(int presid, int ptableno, Model model) {
		logger.info("pos info 실행");

		List<Pos> infoList = posService.info(presid, ptableno);		
		List<Integer> price = posService.calcSum(presid, ptableno);	
		
		int totalPrice = 0;
		for ( int i = 0; i < price.size(); i++ ) {
			totalPrice += price.get(i);
		}
		
		model.addAttribute("ptableno", ptableno);
		model.addAttribute("infoList", infoList);
		model.addAttribute("totalPrice", totalPrice);
		return "pos/info";
	}

}

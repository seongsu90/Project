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
import com.mycompany.ourapp.dto.Restaurant;
import com.mycompany.ourapp.service.FavoriteService;
import com.mycompany.ourapp.service.MemberService;
import com.mycompany.ourapp.service.RestaurantService;

@Controller
@RequestMapping("/favorite")
public class FavoriteController {
	private static final Logger logger = LoggerFactory.getLogger(FavoriteController.class);
	
	@Autowired
	private FavoriteService favoriteService;
	
	@Autowired
	private MemberService memberService;
	
	// Favorite 추가 폼
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addForm() {
		logger.info("addForm() GET 실행");
		return "favorite/addForm";
	}
	
	// Favorite 추가
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(int fresid, HttpSession session, Model model) {
		logger.info("add() POST 실행");
		String fmid = (String) session.getAttribute("login");
		favoriteService.add(fmid, fresid);
		model.addAttribute("member", memberService.info(fmid));
		return "member/info";
	}
	
	// Favorit 목록 보기 ( Restaurant Info 필요함 )
	@RequestMapping("/list")
	public String list(HttpSession session, Model model) {
		logger.info("list() 실행");
		String fmid = (String) session.getAttribute("login");
		Member member = memberService.info(fmid);
		
		List<Restaurant> resList = favoriteService.list(fmid);
		model.addAttribute("resList", resList);
		model.addAttribute("member", member);
		
		return "favorite/list";
	}

}

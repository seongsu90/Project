package com.mycompany.ourapp.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.ourapp.service.FavoriteService;
import com.mycompany.ourapp.service.MemberService;

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
		
		
		return "favorite/list";
	}

}

package com.mycompany.ourapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.ourapp.dto.Pos;
import com.mycompany.ourapp.service.PosService;

@Controller
@RequestMapping("/pos")
public class PosController {
	
	@Autowired
	private PosService posService;
	
	@RequestMapping("/index")
	public String index() {
		return "pos/index";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addForm() {				
		return "pos/addForm";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(Pos pos) {		// 수기 주문, 모바일 주문
		int row = posService.add(pos);	
		return "redirect:/pos/index";	
	}

	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyForm() {
		return "pos/modifyForm";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(Pos pos) {
		return "pos/modify";
	}
	
	@RequestMapping("/delete")
	public String delete(int ptableno, int pResid) {
		posService.delete(ptableno, pResid);
		return "redirect:/pos/index";	
	}
	
	@RequestMapping("/info")	
	public String info(int ptableno, int pResid, Model model) {
		Pos pos = posService.info(ptableno, pResid);
		model.addAttribute("pos", pos);		
		return "pos/info";
	}
	
	@RequestMapping("/calcsum")
	public String calcSum(int ptableno, int pResid, Model model) {
		List<Integer> list = posService.calcSum(ptableno, pResid);
		
		int price = 0;
		for ( int i = 0; i < list.size(); i++ ) {
			price += list.get(i);
		}
		
		model.addAttribute("price", price);
		return "pos/calcSum";
	}
}

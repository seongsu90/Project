package com.mycompany.ourapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.ourapp.dto.MenuList;
import com.mycompany.ourapp.service.MenuListService;

@Controller
@RequestMapping("/menulist")
public class MenuListController {
	
		@Autowired
		private MenuListService menuListService;
		
		@RequestMapping("/index")
		public String index() {
			return "menulist/index";
		}
		
		@RequestMapping(value="/add", method=RequestMethod.GET)
		public String addForm() {				
			return "menulist/addForm";
		}
		
		@RequestMapping(value="/add", method=RequestMethod.POST)
		public String add(MenuList menuList) {		
			int row = menuListService.add(menuList);	
			return "redirect:/menulist/index";	
		}

		@RequestMapping(value="/modify", method=RequestMethod.GET)
		public String modifyForm() {
			return "menulist/modifyForm";
		}
		
		@RequestMapping(value="/modify", method=RequestMethod.POST)
		public String modify(MenuList menuList) {
			return "menulist/modify";
		}
		
		@RequestMapping("/delete")
		public String delete(int mlResid, String mlname) {
			menuListService.delete(mlResid, mlname);
			return "redirect:/menulist/index";	
		}
		
		@RequestMapping("/info")	
		public String info(int mlResid, String mlname, Model model) {
			MenuList menuList = menuListService.info(mlResid, mlname);
			model.addAttribute("menulist", menuList);		
			return "menulist/info";
		}
	
	}
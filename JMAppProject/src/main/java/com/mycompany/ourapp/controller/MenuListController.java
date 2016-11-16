package com.mycompany.ourapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
		
		@RequestMapping("/list")
		public String list(String pageNo, Model model, HttpSession session){
			int intPageNo=1;
			
			if(pageNo==null){
				pageNo=(String) session.getAttribute("pageNo");
				if(pageNo != null){
					intPageNo = Integer.parseInt(pageNo);
				}
			}else{
				intPageNo = Integer.parseInt(pageNo);
			}
			session.setAttribute("pageNo", String.valueOf(intPageNo));
			int rowsPerPage = 8;//한페이지당 보이는 갯수
			int pagesPerGroup = 5;//한그룹당 페이지수 
			
			int totalBoardNo = menuListService.getCount();//총 게시판 갯수
			
			int totalPageNo = (totalBoardNo/rowsPerPage)+((totalBoardNo%rowsPerPage!=0)?1:0);//총 페이지수
			//                       정수/정수 =정수               나머지가있다면 1을 더해주고 없다면 0 
			
			int totalGroupNo = (totalPageNo/pagesPerGroup)+((totalPageNo%pagesPerGroup!=0)?1:0);
			
			int groupNo = (intPageNo-1)/pagesPerGroup+1;
			
			int startPageNo = (groupNo-1)*pagesPerGroup+1;
			
			int endPageNo = startPageNo+pagesPerGroup-1;
			
			if(groupNo == totalGroupNo) {endPageNo=totalPageNo;}
			
			List<MenuList> list = menuListService.list(intPageNo,rowsPerPage);
			
			model.addAttribute("intPageNo",intPageNo);
			model.addAttribute("rowsPerPage",rowsPerPage);	
			model.addAttribute("pagesPerGroup",pagesPerGroup);
			model.addAttribute("totalBoardNo",totalBoardNo);
			model.addAttribute("totalPageNo",totalPageNo);
			model.addAttribute("totalGroupNo",totalGroupNo);
			model.addAttribute("groupNo",groupNo);
			model.addAttribute("startPageNo",startPageNo);
			model.addAttribute("endPageNo",endPageNo);
			model.addAttribute("list", list);
			
			return "menulist/list";
		}
		
		@RequestMapping("/index")
		public String index() {
			return "menulist/index";
		}
		
		@RequestMapping(value="/add", method=RequestMethod.GET)
		public String addForm(MenuList menuList) {				
			return "menulist/addForm";
		}
		
		@RequestMapping(value="/add", method=RequestMethod.POST)
		public String add(MenuList menuList) {		
		   menuListService.add(menuList);	
			return "redirect:/menulist/index";	
		}

		@RequestMapping(value="/modify", method=RequestMethod.GET)
		public String modifyForm() {
			return "menulist/modify";
		}
		
		@RequestMapping(value="/modify", method=RequestMethod.POST)
		public String modify(MenuList menuList) {
			return "redirect:/menulist/list";
		}
		
		@RequestMapping("/delete")
		public String delete(int mlresid, String mlname) {
			menuListService.delete(mlresid, mlname);
			return "redirect:/menulist/list";	
		}
		
		@RequestMapping("/info")	
		public String info(int mlresid, String mlname, Model model) {
			List<MenuList> list = menuListService.info(mlresid, mlname);
			model.addAttribute("mlresid", mlresid);
			model.addAttribute("mlname", mlname);
			return "menulist/info";
		}
	
	}
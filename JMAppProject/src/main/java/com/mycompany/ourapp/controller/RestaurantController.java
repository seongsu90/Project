package com.mycompany.ourapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.PhotoBoard;
import com.mycompany.ourapp.dto.Restaurant;
import com.mycompany.ourapp.service.RestaurantService;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addForm(Restaurant restaurant){
		return "restaurant/addForm";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(Restaurant restaurant){
		try{
			int result=restaurantService.add(restaurant);
			return "redirect:/restaurant/add";
	
		}catch(Exception e){
			return "restaurant/addForm";
		}
	}
	
	@RequestMapping("/delete")
	public String delete(int resid){
		restaurantService.delete(resid);
		return "redirect:/restaurant/list";
	}
	
	@RequestMapping("/info")
	public String info(int resid, Model model){
		Restaurant restaurant=restaurantService.info(resid);
		model.addAttribute("restaurant", restaurant);
		return "restaurant/info";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyForm(int bno, Model model){
		PhotoBoard photoBoard=photoBoardService.info(bno);
		model.addAttribute("photoboard",photoBoard);
		return "photoboard/modify";
	}
	
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(Restaurant restaurant){
		PhotoBoard dbPhotoBoard=photoBoardService.info(photoBoard.getBno());
		photoBoard.setBhitcount(dbPhotoBoard.getBhitcount());
		photoBoardService.modify(photoBoard);
		return "redirect:/photoboard/list";
	}
	
	

}

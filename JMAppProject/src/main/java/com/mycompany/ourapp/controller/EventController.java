package com.mycompany.ourapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.ourapp.dto.Event;
import com.mycompany.ourapp.service.EventService;

@Controller
@RequestMapping("/event")
public class EventController {
	@Autowired
	private EventService eventService;
	
	@RequestMapping("/index")
	public String index() {
		return "event/index";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addForm(Event event){
		return "event/addForm";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(Event event){
		try{
			int result=eventService.add(event);
			return "redirect:/event/add";
	
		}catch(Exception e){
			return "event/addForm";
		}
	}
	
	@RequestMapping("/delete")
	public String delete(int eResid,String eMlname){
		eventService.delete(eResid,eMlname);
		return "event/info";
	}
	
	@RequestMapping("/info")
	public String info(int eResid,String eMlname, Model model){
		Event event=eventService.info(eResid,eMlname);
		model.addAttribute("event", event);
		return "event/info";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyForm(int eResid,String eMlname, Model model){
		Event event=eventService.info(eResid,eMlname);
		model.addAttribute("event", event);
		return "event/modify";
	}
	
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(Event event){
		Event dbEvent=eventService.info(event.geteResid(),event.geteMlname());
		eventService.modify(event);
		return "redirect:/event/info";
	}
}
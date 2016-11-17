package com.mycompany.ourapp.controller;





import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory.getLogger(EventController.class);
	@Autowired
	private EventService eventService;
	
	@RequestMapping("/index")
	public String index() {
		logger.info("index 요청처리");
		return "event/index";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addForm(){
		logger.info("addForm 요청처리");
		return "event/addForm";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(Event event){
		logger.info("add 요청처리");
		eventService.add(event);
		return "redirect:/event/index";
	}
	
	@RequestMapping("/delete")
	public String delete(int eresid,String emlname){
		logger.info("delete 요청처리");
		eventService.delete(eresid,emlname);
		return "redirect:/event/index";
	}
	
	@RequestMapping("/info")
	public String info(int eresid,String emlname, Model model){
		logger.info("info 요청처리");
		Event event=eventService.info(eresid,emlname);
		model.addAttribute("eresid", eresid);
		model.addAttribute("emlname", emlname);
		return "event/info";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyForm(){
		logger.info("modify 요청처리");
		return "event/modify";
	}
	
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(Event event){
		logger.info("modify 요청처리");
		eventService.modify(event);
		
		return "redirect:/event/index";
	}
	
	
}
package com.mycompany.ourapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.ourapp.dto.Review;
import com.mycompany.ourapp.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String writeForm() {
		return "review/writeForm";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(Review review, HttpSession session) {
		String mid = (String) session.getAttribute("login");
		int revresid = (int) session.getAttribute("presid");
		review.setRevmid(mid);
		review.setRevresid(revresid);
		
		int result = reviewService.write(review);
		if ( result == reviewService.WRITE_FAIL ) {
			return "review/write";
		}	 
		return "review/list";
		//return "redirect:/";
	}
	
	@RequestMapping("/delete")
	public String delete(int revno) {
		reviewService.delete(revno);
		return "redirect:/";
	}
	
	@RequestMapping("/info")
	public String info(int revno, Model model) {	
		Review review = reviewService.info(revno);
		model.addAttribute("review", review);
		return "review/info";
	}
	
	@RequestMapping("/list")
	public String list(int revno, Model model) {	
		Review review = reviewService.info(revno);
		model.addAttribute("review", review);
		return "review/list";
	}
	
}

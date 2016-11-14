package com.mycompany.ourapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.ourapp.dto.Member;
import com.mycompany.ourapp.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() {
		logger.info("loginForm() GET 실행");
		return "member/loginForm";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String mid, String mpassword, HttpSession session, Model model) {
		logger.info("login() POST 실행");
		int result = memberService.login(mid, mpassword);
		if ( result == MemberService.LOGIN_FAIL_MPASSWORD ) {
			model.addAttribute("error", "LOGIN_FAIL_MPASSWORD");
			return "member/loginForm";
		} else if ( result == MemberService.LOGIN_FAIL_MID) {
			model.addAttribute("error", "LOGIN_FAIL_MID");
			return "member/loginForm";
		} else {
			session.setAttribute("login", mid);
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/findMid", method=RequestMethod.GET)
	public String findMidForm() {
		logger.info("findMidForm() GET 실행");
		return "member/findMidForm";
	}
	
	@RequestMapping(value="/findMid", method=RequestMethod.POST)
	public String findMid(String mname, String mphone, Model model, HttpSession session) {
		logger.info("findMid() POST 실행");
		String mid = memberService.findMid(mname, mphone);
		if ( mid == null ) {
			model.addAttribute("error", " 입력하신 이름과 번호를 가진 id가 없습니다.");
			return "member/findMidForm";
		}
		session.setAttribute("findMid", mid);
		return "redirect:/member/login";
	}
	
	@RequestMapping(value="/findMpassword", method=RequestMethod.GET)
	public String findMpasswordForm() {
		logger.info("findMpasswordForm() GET 실행");
		return "member/findMpasswordForm";
	}
	
	@RequestMapping(value="/findMpassword", method=RequestMethod.POST)
	public String findMpassword(String mid, String mphone, Model model, HttpSession session) {
		logger.info("findMpassword() POST 실행");
		Member member = memberService.info(mid);
		if ( member == null ) {
			model.addAttribute("error", " 존재하지 않는 id입니다.");
			return "member/findMpasswordForm";
		}
		if ( member.getMphone().equals(mphone) ) {
			session.setAttribute("findMid", mid);
			return "redirect:/member/mpasswordReset";
		} else {
			model.addAttribute("error", " 휴대폰 번호가 일치하지 않습니다.");
			return "member/findMpasswordForm";
		}
		
	}
	
	@RequestMapping(value="/mpasswordReset", method=RequestMethod.GET)
	public String mpasswordResetForm() {
		logger.info("mpasswordResetForm() GET 실행");
		return "member/mpasswordResetForm";
	}
	
	@RequestMapping(value="/mpasswordReset", method=RequestMethod.POST)
	public String mpasswordReset(String mid, String mpassword, String mpassword2, Model model) {
		logger.info("mpasswordReset() POST 실행");
		Member member = memberService.info(mid);
		if ( mpassword.equals(mpassword2) ) {
			member.setMpassword(mpassword);
			memberService.modify(member);
			return "redirect:/member/login";
		} else {
			model.addAttribute("error", " 비밀번호가 일치하지 않습니다.");
			return "member/mpasswordResetForm";
		}
		
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm() {
		logger.info("joinForm() GET 실행");
		return "member/joinForm";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Member member, Model model) {
		logger.info("join() POST 실행");
		try {
			int result = memberService.join(member);
			return "redirect:/member/login";
		} catch (DuplicateKeyException e) {
			model.addAttribute("error", " 아이디가 존재합니다. 다른 아이디를 입력해 주세요.");
			return "member/joinForm";
		} catch (Exception e1) {
			model.addAttribute("error2", " 모든 항목을 입력해 주세요");
			return "member/joinForm";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		logger.info("logout() GET 실행");
		String mid = (String) session.getAttribute("login");
		int result = memberService.logout(mid);
		if ( result == MemberService.LOGOUT_SUCCESS ) {
			session.removeAttribute("login");
		}		
		return "redirect:/";
	}
	
	// 회원 정보보기. jsp랑 태그 필요
	@RequestMapping("/info")
	public String info(String mpassword, HttpSession session, Model model) {
		logger.info("info() GET 실행");
		String mid = (String) session.getAttribute("login");
		Member member = memberService.info(mid, mpassword);
		model.addAttribute("member", member);
		return "member/info";
	}
	
	// 회원 리스트 보기 ( 미완성 )
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(String pageNo, @RequestParam(required=false, defaultValue="") String find, Model model, HttpSession session) {
		logger.info("list() 실행");
		int intPageNo = 1;
		if ( pageNo == null ) {
			pageNo = (String) session.getAttribute("pageNo");
			if ( pageNo != null ) {
				intPageNo = Integer.parseInt(pageNo);
			}
		} else {
			intPageNo = Integer.parseInt(pageNo);
		}
		session.setAttribute("pageNo", String.valueOf(intPageNo));
		
		int rowsPerPage = 10;
		int pagesPerGroup = 5;
		
		int totalMemberNo = memberService.getCount(find);
		
		int totalPageNo = totalMemberNo / rowsPerPage + ((totalMemberNo%rowsPerPage!=0)?1:0);
		int totalGroupNo = totalPageNo / pagesPerGroup + ((totalPageNo%pagesPerGroup!=0)?1:0);
		
		int groupNo = (intPageNo-1) / pagesPerGroup + 1;
		int startPageNo = (groupNo-1) * pagesPerGroup + 1;
		int endPageNo = startPageNo + pagesPerGroup - 1;
		if ( groupNo == totalGroupNo ) endPageNo = totalPageNo;
		
		List<Member> list = memberService.list(intPageNo, rowsPerPage, find);	
		
		model.addAttribute("rowsPerPage", rowsPerPage);
		model.addAttribute("pageNo", intPageNo);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalBoardNo", totalMemberNo);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("find", find);
		model.addAttribute("list", list);
		
		return "member/list";	
	}
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String findList(String pageNo, String find, Model model) {
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("find", find);

		return "redirect:/member/list";		
	}

}
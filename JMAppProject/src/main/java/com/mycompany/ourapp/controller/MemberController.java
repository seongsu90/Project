package com.mycompany.ourapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.UncategorizedSQLException;
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
	
	// 로그인 폼
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() {
		logger.info("loginForm() GET 실행");
		return "member/loginForm";
	}
	
	// 로그인
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
			session.setAttribute("mrank", memberService.info(mid).getMrank());
			return "redirect:/";
		}
	}
	
	// 아이디 찾기 폼
	@RequestMapping(value="/findMid", method=RequestMethod.GET)
	public String findMidForm() {
		logger.info("findMidForm() GET 실행");
		return "member/findMidForm";
	}
	
	// 아이디 찾기
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
	
	// 비밀번호 찾기 폼
	@RequestMapping(value="/findMpassword", method=RequestMethod.GET)
	public String findMpasswordForm() {
		logger.info("findMpasswordForm() GET 실행");
		return "member/findMpasswordForm";
	}
	
	// 비밀번호 찾기
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
	
	// 비밀번호 재설정 폼
	@RequestMapping(value="/mpasswordReset", method=RequestMethod.GET)
	public String mpasswordResetForm() {
		logger.info("mpasswordResetForm() GET 실행");
		return "member/mpasswordResetForm";
	}
	
	// 비밀번호 재설정 
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
	
	// 회원가입 폼
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm() {
		logger.info("joinForm() GET 실행");
		return "member/joinForm";
	}
	
	// 회원가입
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Member member, Model model) {
		logger.info("join() POST 실행");
		try {
			int result = memberService.join(member);
			return "redirect:/member/login";
		} catch ( UncategorizedSQLException e ) {
			model.addAttribute("error", " 20자 이하의 아이디를 입력하세요");
			return "member/joinForm";
		} catch (DuplicateKeyException e1) {
			model.addAttribute("error", " 아이디가 존재합니다. 다른 아이디를 입력해 주세요.");
			return "member/joinForm";
		} catch (Exception e2) {
			e2.printStackTrace();
			model.addAttribute("error2", " 모든 항목을 입력해 주세요");
			return "member/joinForm";
		}
	}
	
	// 회원 정보보기 ( 사용자 기준 )
	@RequestMapping("/info")
	public String info(String mid, Model model) {
		logger.info("info() 실행");
		Member member = memberService.info(mid);
		model.addAttribute("member", member);
		return "member/info";
	}
	
	// 회원 리스트 보기
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list() {
		return "web/memberindex";	
	}
	
	@RequestMapping(value="/memberboard", method=RequestMethod.GET)
	public String memberboard(String pageNo, @RequestParam(required=false, defaultValue="") String find, Model model, HttpSession session) {
		logger.info("list() GET 실행");
/*
		String mid = (String) session.getAttribute("login");
		Member member = memberService.info(mid);
		if ( member == null || member.getMrank() != 2 ) {
			return "redirect:/";
		}
*/
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
		
		int rowsPerPage = 5;
		int pagesPerGroup = 5;
		
		int totalMemberNo = memberService.getCount(find);
		if ( totalMemberNo == 0 ) totalMemberNo = 1;
		
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
		
		return "web/memberboard";	
	}
	
	// 회원 검색 ( mid, mname 기준 ) 
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String findList(String pageNo, String find, Model model) {
		logger.info("findList() POST 실행");
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("find", find);

		return "redirect:/member/list";		
	}
	
	// 회원 수정하기 폼
	@RequestMapping(value="/modifyInfo", method=RequestMethod.GET)
	public String modifyInfoForm(String mid, HttpSession session, Model model) {
		Member loginMember = memberService.info((String) session.getAttribute("login"));
		Member member = memberService.info(mid);
		String selectedLocation[] = member.getMlocation().split(" ");
		if ( selectedLocation.length == 3 ) {
			selectedLocation[1] += (" " + selectedLocation[2]);
		}
		model.addAttribute("slocation", selectedLocation);
		model.addAttribute("member", member);
		if ( loginMember.getMrank() == 2 ) {
			logger.info("modifyInfoForm() ( Manager ) GET 실행");
			return "member/modifyInfoForManagerForm";			
		} else {
			logger.info("modifyInfoForm() GET 실행");
			return "member/modifyInfoForm";
		}
	}
	
	// 회원 수정
	/*@RequestMapping(value="/modifyInfo", method=RequestMethod.POST)
	public String modifyInfo(Member member, String newmpassword, Model model, HttpSession session) {
		String mid = (String) session.getAttribute("login");
		Member dbmember = memberService.info(mid);
		if (dbmember.getMrank() == 2) {
			try {
				memberService.modify(member);
				return "redirect:/member/list";
			} catch (DataIntegrityViolationException e) {
				model.addAttribute("member", member);
				model.addAttribute("error", " 입력하신 id의 레스토랑이 없습니다.");
				return "member/modifyInfoForManagerForm";
			} catch (Exception e1) {
				model.addAttribute("member", member);
				model.addAttribute("error", " 모든 항목을 입력해 주세요");
				return "member/modifyInfoForManagerForm";
			}
		} else {
			if ( dbmember.getMpassword().equals(member.getMpassword()) ) {
				dbmember.setMphone(member.getMphone());
				dbmember.setMlocation(member.getMlocation());
				dbmember.setMpassword(newmpassword);
				try {
					memberService.modify(dbmember);
					return "redirect:/member/info?mid=" + mid;
				} catch (Exception e) {
					model.addAttribute("member", dbmember);
					model.addAttribute("error", " 모든 항목을 입력해 주세요");
					return "member/modifyInfoForm";
				}
			} else {
				model.addAttribute("member", member);
				model.addAttribute("error", " 비밀번호가 틀렸습니다");
				return "member/modifyInfoForm";
			}
		}
	}*/
	
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(Member member, String newmpassword, Model model, HttpSession session) {
		String mid = (String) session.getAttribute("login");
		Member dbmember = memberService.info(mid);
		if (dbmember.getMrank() == 2) {
			String result = "success";
			try {
				memberService.modify(member);
			} catch (DataIntegrityViolationException e) {
				result = "noRestaurant";
			} catch (Exception e1) {
				e1.printStackTrace();
				result = "wrongData";
			}
			model.addAttribute("result", result);
			return "member/modify";
		} else {
			if ( dbmember.getMpassword().equals(member.getMpassword()) ) {
				dbmember.setMphone(member.getMphone());
				dbmember.setMlocation(member.getMlocation());
				dbmember.setMpassword(newmpassword);
				try {
					memberService.modify(dbmember);
					return "redirect:/member/info?mid=" + mid;
				} catch (Exception e) {
					model.addAttribute("member", dbmember);
					model.addAttribute("error", " 모든 항목을 입력해 주세요");
					return "member/modifyInfoForm";
				}
			} else {
				model.addAttribute("member", member);
				model.addAttribute("error", " 비밀번호가 틀렸습니다");
				return "member/modifyInfoForm";
			}
		}
	}

/*	
	// 회원 정보 수정 폼(Manager)
	@RequestMapping(value="/modifyInfoForManager", method=RequestMethod.GET)
	public String modifyInfoForManagerForm(String mid,  Model model) {
		logger.info("modifyInfoForManagerForm() GET 실행");
		Member member = memberService.info(mid);
		String selectedLocation[] = member.getMlocation().split(" ");
		if ( selectedLocation.length == 3 ) {
			selectedLocation[1] += (" " + selectedLocation[2]);
		}
		model.addAttribute("slocation", selectedLocation);
		model.addAttribute("member", member);
		return "member/modifyInfoForManagerForm";
	}
	
	// 회원 정보 수정 (Manager)
	@RequestMapping(value="/modifyInfoForManager", method=RequestMethod.POST)
	public String modifyInfoForManager(Member member, Model model) {
		logger.info("modifyInfoForManager() POST 실행");
			try {
				memberService.modify(member);
				return "redirect:/member/list";
			} catch (DataIntegrityViolationException e) {
				model.addAttribute("member", member);
				model.addAttribute("error", " 입력하신 id의 레스토랑이 없습니다.");
				return "member/modifyInfoForManagerForm";
			}
			catch (Exception e1) {
				model.addAttribute("member", member);
				model.addAttribute("error", " 모든 항목을 입력해 주세요");
				return "member/modifyInfoForManagerForm";
			}
	}
*/
	
	// 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		logger.info("logout() GET 실행");
		String mid = (String) session.getAttribute("login");
		int result = memberService.logout(mid);
		if ( result == MemberService.LOGOUT_SUCCESS ) {
			session.removeAttribute("login");
			session.removeAttribute("mrank");
		}		
		return "redirect:/";
	}
	
	// 탈퇴하기 폼 ( 비밀번호 확인 )
	@RequestMapping(value="/withdraw", method=RequestMethod.GET)
	public String withdrawForm() {
		logger.info("withdrawForm() GET 실행");	
		return "member/withdrawForm";
	}
	
	// 탈퇴
	@RequestMapping(value="/withdraw", method=RequestMethod.POST)
	public String withdraw(String mpassword, HttpSession session, Model model) {
		logger.info("withdraw() POST 실행");
		String mid = (String) session.getAttribute("login");
		int result = memberService.withdraw(mid, mpassword); 
		if ( result == MemberService.WITHDRAW_SUCCESS ){
			session.removeAttribute("login");
			return "redirect:/";			
		} else {
			model.addAttribute("error", " 비밀번호가 일치하지 않습니다.");
			return "member/withdrawForm";
		}
						
	}
	
	
}
package com.mycompany.myweb2.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb2.dto.PhotoBoard;
import com.mycompany.myweb2.service.PhotoBoardService;


@Controller
@RequestMapping("/photoboard")
public class PhotoBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(PhotoBoardController.class);
	@Autowired
	private PhotoBoardService photoBoardService;
	
	@RequestMapping("/list")
	public String list(String pageNo,Model model,HttpSession session){
		int intPageNo =1;
		if(pageNo==null)
		{
			pageNo = (String) session.getAttribute("pageNo");
			if(pageNo != null) //넘어오지도 않고 세션에 존재하지도 않을 때는 1페이를 넘겨주게끔 셋팅
				{
					intPageNo =Integer.parseInt(pageNo)	;
				}
		}else
		{
			intPageNo = Integer.parseInt(pageNo);
		}
		session.setAttribute("pageNo", String.valueOf(intPageNo));
		
		int rowsPerPage = 8;
		int pagesPerGroup =5;
		
		int totalBoardNo = photoBoardService.getCount();
		
		int totalPageNo = totalBoardNo/rowsPerPage + ((totalBoardNo%rowsPerPage!=0)?1:0); //나머지가 있다면 1을 더하고 없으면 0을 더한다.
		int totalGroupNo = (totalPageNo/pagesPerGroup)+((totalPageNo%pagesPerGroup!=0)?1:0);
		
		int groupNo = (intPageNo-1)/ pagesPerGroup +1;
		int startPageNo = (groupNo-1)*pagesPerGroup +1;
		int endPageNo = startPageNo + pagesPerGroup -1;
		
		if(groupNo==totalGroupNo){endPageNo= totalPageNo;}
		
		List<PhotoBoard> list = photoBoardService.list(intPageNo, rowsPerPage);
		model.addAttribute("pageNo",intPageNo);
		model.addAttribute("rowsPerPage",rowsPerPage);
		model.addAttribute("pagesPerGroup",pagesPerGroup);
		model.addAttribute("totalPageNo",totalPageNo);
		model.addAttribute("totalBoardNo",totalBoardNo);
		model.addAttribute("totalGroupNo",totalGroupNo);
		model.addAttribute("groupNo",groupNo);
		model.addAttribute("startPageNo",startPageNo);
		model.addAttribute("endPageNo",endPageNo);
		model.addAttribute("list",list);
		return "photoboard/list";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(){
		return "photoboard/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(PhotoBoard photoBoard,HttpSession session){
		try{
			String mid = (String) session.getAttribute("login");
			photoBoard.setBwriter(mid);
			
			logger.info(session.toString());
			
			photoBoard.setOriginalfile(photoBoard.getPhoto().getOriginalFilename());
			String savedfile = new Date().getTime() + photoBoard.getPhoto().getOriginalFilename(); // 저장하는 파일이 유일해야하기 때문에 날짜를 붙인다.
			String realPath = session.getServletContext().getRealPath("/WEB-INF/photo/"+savedfile);
			photoBoard.getPhoto().transferTo(new File(realPath)); // 지정된 경로로 파일을 저장한다는것? 83,84,실제 파일시스템을 저장
			photoBoard.setSavedfile(savedfile);
			
			photoBoard.setMimetype(photoBoard.getPhoto().getContentType());
			
			int result =photoBoardService.write(photoBoard);
			return "redirect:/photoboard/list";
			}
			catch (Exception e) {
			e.printStackTrace();
			return "photoboard/write";
		}
	}
	
	@RequestMapping("/show")
	public void showPhoto(String savedfile, HttpServletRequest req,HttpServletResponse rs)
	{
		try{
		String fileName = savedfile;	
		
		/*
		브라우저에서 보여주지 않고 강제로 다운로드 할 경우
		fileName = URLEncoder.encode(fileName,"UTF-8"); // 파일이름을 한글로 다운받을때 인코딩을 해야된다.
		response.setHeader("Content-Disposition", "attachment; filename=\"사진1.jpg\""); //다운로드 설정\"222\" 로하면 이름 사이에 공백이있어도 인식한다.
		rs.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\"");
		*/
		String mimeType = req.getServletContext().getMimeType(fileName);
		
		rs.setContentType(mimeType);
		
		OutputStream os = rs.getOutputStream();
		
		String filePath = req.getServletContext().getRealPath("/WEB-INF/photo/"+fileName);
		InputStream is = new FileInputStream(filePath);
		byte[] values = new byte[1024];
		
		
		int byteNum = -1;
		while((byteNum=is.read(values))!=-1)
		{
			os.write(values,0,byteNum);
		}
		os.flush();
		is.close();
		os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/info")
	public String info(int bno,Model model)
	{
		PhotoBoard photoBoard = photoBoardService.info(bno);
		photoBoard.setBhitcount(photoBoard.getBhitcount()+1);
		photoBoardService.modify(photoBoard);
		model.addAttribute("photoBoard",photoBoard);
		return "photoboard/info";
	}
	
	@RequestMapping(value="/modify", method= RequestMethod.GET)
	public String modifyform(int bno,Model model)
	{
		PhotoBoard photoBoard = photoBoardService.info(bno);
		model.addAttribute("photoBoard",photoBoard);
		logger.info("수정폼 가기");
		return "photoboard/modify";
	}
	
	@RequestMapping(value="/modify", method= RequestMethod.POST)
	public String modify(PhotoBoard photoBoard, HttpSession session) throws Exception
	{
		logger.info("수정처리");
		String mid = (String) session.getAttribute("login");
		photoBoard.setBwriter(mid);
		
		PhotoBoard dbPhotoBoard = photoBoardService.info(photoBoard.getBno());
		photoBoard.setBhitcount(dbPhotoBoard.getBhitcount());
		
		photoBoard.setOriginalfile(photoBoard.getPhoto().getOriginalFilename());
		String savedfile = new Date().getTime() + photoBoard.getPhoto().getOriginalFilename(); // 저장하는 파일이 유일해야하기 때문에 날짜를 붙인다.
		String realPath = session.getServletContext().getRealPath("/WEB-INF/photo/"+savedfile);
		photoBoard.getPhoto().transferTo(new File(realPath)); // 지정된 경로로 파일을 저장한다는것? 83,84,실제 파일시스템을 저장
		photoBoard.setSavedfile(savedfile);
		
		photoBoard.setMimetype(photoBoard.getPhoto().getContentType());
		photoBoardService.modify(photoBoard);
		return "redirect:/photoboard/list";
	}
	
	@RequestMapping("/delete")
	public String delete(int bno)
	{
		photoBoardService.remove(bno);
		return "redirect:/photoboard/list";
	}
}

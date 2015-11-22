package com.mybatis.joongnam3;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mybatis.service.BoardService;
import mybatis.service.CategoryService;
import mybatis.service.UserService;
import mybatis.vo.Board;
import mybatis.vo.Category;
import mybatis.vo.UserVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService service;
	@Autowired
	UserService UserService;
	@Autowired
	CategoryService categoryService;

	@RequestMapping("board.do")
	public ModelAndView board(Locale locale,HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome board! The client locale is {}.", locale);
		
		ModelAndView modelAndView = new ModelAndView();

		int totalCount = Integer.parseInt(request.getParameter("totalCount"));
		int page = Integer.parseInt(request.getParameter("page"));
		int idx = 1;
		try{
			idx =  Integer.parseInt(request.getParameter("idx"));
		} catch(Exception e){
			idx = 1;
		}
		
		//	이전 con_no값 찾기
		int prevIdx=idx-1;
		for(int i=prevIdx;i>0;i--){
			try {
				prevIdx = service.showBoard(i).getCon_no();
				break;
			} catch (Exception e) {
			}
		}
		
		//	다음 con_no값 찾기
		int nextIdx=idx+1;
		for(int j=nextIdx;j<=totalCount;j++){
			try {
				nextIdx = service.showBoard(j).getCon_no();
				break;
			} catch (Exception e) {
			}
		}
		
		Board board = service.showBoard(idx);
		Category category = categoryService.showCategory(Integer.parseInt(request.getParameter("category")));

		// login Information
		HttpSession session = request.getSession();	
		int log = 0;
		try {
			log = Integer.parseInt(request.getParameter("log"));
		} catch (Exception e) {
			log = 0;
		}
		if(log==1){
			UserVo user = new UserVo();
			user.setUserId((String) session.getAttribute("userId"));
			user.setUserPassword((String) session.getAttribute("userPassword"));
			user.setUserName((String) session.getAttribute("userName"));
			user.setUserBirthday((String) session.getAttribute("userBirthday"));
			user.setUserSeq((Integer) session.getAttribute("userSeq"));
			modelAndView.addObject("user", user);
		}
		modelAndView.addObject("log", log);
		///////////////////////////////////////////////
		int min = service.min();
		int max = service.max();
		System.out.println("min = "+min+", max = "+max);
		
		modelAndView.addObject("totalCount", totalCount);
		modelAndView.addObject("min", min);
		modelAndView.addObject("max", max);
		modelAndView.addObject("prevIdx", prevIdx);
		modelAndView.addObject("nextIdx", nextIdx);
		modelAndView.addObject("currentIdx", idx);
		modelAndView.addObject("currentPage", page);
		modelAndView.addObject("bo", board);
		modelAndView.addObject("category", category);
		modelAndView.setViewName("board");
		
		return modelAndView;
	}
}

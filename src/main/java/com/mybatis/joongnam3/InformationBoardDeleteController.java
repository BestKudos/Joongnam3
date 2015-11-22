package com.mybatis.joongnam3;

import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mybatis.service.CategoryService;
import mybatis.service.InformationBoardService;
import mybatis.vo.Category;
import mybatis.vo.InformationBoard;
import mybatis.vo.UserVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InformationBoardDeleteController {
	private static final Logger logger = LoggerFactory.getLogger(InformationBoardDeleteController.class);
	
	@Autowired
	InformationBoardService service;
	@Autowired
	CategoryService categoryService;

	@RequestMapping("informationboarddelete.do")
	public ModelAndView informationboarddelete(Locale locale,HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome informationboarddelete! The client locale is {}.", locale);
		
		ModelAndView modelAndView = new ModelAndView();
		Category category = categoryService.showCategory(Integer.parseInt(request.getParameter("category")));

		int page = Integer.parseInt(request.getParameter("page"));
		int idx = 1;
		try{
			idx =  Integer.parseInt(request.getParameter("idx"));
		} catch(Exception e){
			idx = 1;
		}

		HashMap<String, Integer> m = new HashMap<String, Integer>();
		m.put("con_no", idx);
		m.put("category_no", category.getCategory_no());
		InformationBoard board = service.showBoard(m);

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
		
		modelAndView.addObject("currentIdx", idx);
		modelAndView.addObject("currentPage", page);
		modelAndView.addObject("category", category);
		modelAndView.addObject("bo", board);
		modelAndView.setViewName("informationboarddelete");
		
		return modelAndView;
	}
}

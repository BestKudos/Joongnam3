package com.mybatis.joongnam3;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mybatis.service.CategoryService;
import mybatis.vo.Category;
import mybatis.vo.UserVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HobbyInsertController {
	private static final Logger logger = LoggerFactory
			.getLogger(HobbyInsertController.class);
	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "hobbyboardwrite.do")
	public ModelAndView hobbyboardwrite(Locale locale, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("Welcome HobbyInsert! The client locale is {}.", locale);

		ModelAndView modelAndView = new ModelAndView();

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
		Category category = categoryService.showCategory(Integer.parseInt(request.getParameter("category")));
		
		modelAndView.addObject("category", category);
		modelAndView.setViewName("hobbyboardwrite");

		return modelAndView;
	}
}

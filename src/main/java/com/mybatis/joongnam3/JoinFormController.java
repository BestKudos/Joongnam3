package com.mybatis.joongnam3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mybatis.vo.UserVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JoinFormController {
	
	private static final Logger logger = LoggerFactory.getLogger(JoinFormController.class);
	
	@RequestMapping("joinForm.do")
	public ModelAndView join(HttpServletRequest request) {
		
		logger.info("Welcome Join Form");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("../../excludes/user/joinForm");
		
		return mav; 
		
	}
}

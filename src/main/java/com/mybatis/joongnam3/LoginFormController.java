package com.mybatis.joongnam3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginFormController {

	private static final Logger logger = LoggerFactory.getLogger(LoginFormController.class);
	
	@RequestMapping("loginForm.do")
	public ModelAndView loginForm() {
		
		logger.info("LoginController INIT");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("../../excludes/user/loginForm");
		
		return mav; 
		
	}
}

package com.mybatis.joongnam3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mybatis.service.UserService;
import mybatis.util.Util;
import mybatis.vo.UserVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	UserVo userVo;

	@Autowired
	UserService service;
	
	@RequestMapping("login.do")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response ) throws IOException {
		
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		
		
		Map<String, String> map = new HashMap<String, String>();
		
		String id = Util.nullCheck(request.getParameter("id"), "");
		String password = Util.nullCheck(request.getParameter("password"), "");
		
		map.put("id",id);
		map.put("password", password);
		
		int loginValue = 0;
		
		try {  loginValue = service.getLoginResult(map);  } catch (Exception e) { }
		
		
		if (loginValue == 1)
		{
			logger.info("Main - Contents");
			
			userVo = service.getUserInfo(id);
			
			session.setAttribute("userId", userVo.getUserId());
			session.setAttribute("userPassword", userVo.getUserPassword());
			session.setAttribute("userBirthday", userVo.getUserBirthday());
			session.setAttribute("userName", userVo.getUserName());
			session.setAttribute("userSeq", userVo.getUserSeq());
			System.out.println();
			mav.setViewName("contents");
			response.sendRedirect("contents.do?log=1");
		}
		else
		{
			logger.info("loginForm");
			mav.setViewName("../../excludes/user/loginForm");
		}
		
		return mav; 
		
	}
}

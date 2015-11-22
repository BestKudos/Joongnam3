package com.mybatis.joongnam3;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.service.UserService;
import mybatis.vo.UserVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JoinResponseAjaxData {

	private static final Logger logger = LoggerFactory
			.getLogger(JoinResponseAjaxData.class);

	@Autowired
	UserService service;

	@RequestMapping("joinAjax.do")
	public ModelAndView joinAjax(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String result = "0";

		logger.info("User Join AjaxData");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("../../excludes/ajax/joinAjaxData");

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String birthday = request.getParameter("birthday");
		String name = request.getParameter("name");

		UserVo userVo = new UserVo();
		userVo.setUserId(id);
		userVo.setUserPassword(password);
		userVo.setUserName(name);
		userVo.setUserBirthday(birthday);

		int resultValue = 0;

		try {
			resultValue = service.insertUser(userVo);
		} catch (Exception e) {
		}

		if (resultValue == 1) {
			result = "1";
		}
		mav.addObject("result", result);
		
		
		return mav;

	}
	
	@RequestMapping("ajax.do")
	public ModelAndView ajax(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("../../excludes/ajax/joinAjaxData");
		int idresult = 0;
		int idmsg = 0;
		try {
			idresult = service.getUserIdCheck(request.getParameter("did"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(idresult == 0) {
			idmsg = 0;
		} else {
			idmsg = 1;
		}
		
		mav.addObject("idmsg", idmsg);
		
		return mav;
	}

}

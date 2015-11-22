package com.mybatis.joongnam3;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mybatis.service.SelectContentsFListService;
import mybatis.service.SelectContentsSListService;
import mybatis.util.ListUtil;
import mybatis.vo.UserVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController{
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	SelectContentsFListService firstService;
	@Autowired
	SelectContentsSListService secondService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws IOException 
	 */
	@RequestMapping("contents.do")
	public ModelAndView home(Locale locale,HttpServletRequest request,HttpServletResponse response) throws IOException {
		logger.info("Welcome home! The client locale is {}.", locale);
		                                                               
		HttpSession session = request.getSession();
		ModelAndView modelAndView = new ModelAndView();
		
		int boardidx = 0;
		try {
			boardidx = Integer.parseInt(request.getParameter("boardidx"));
		} catch (Exception e) {
			boardidx = 0;
		}
		if(boardidx == 1)
			response.sendRedirect("boardlist");
		
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
		
		ListUtil lu1 = firstService.getList(11);
		modelAndView.addObject("lu1", lu1);
		ListUtil lu2 = firstService.getList(12);
		modelAndView.addObject("lu2", lu2);
		ListUtil lu3 = firstService.getList(13);
		modelAndView.addObject("lu3", lu3);
		ListUtil lu4 = firstService.getList(14);
		modelAndView.addObject("lu4", lu4);
		ListUtil luF = secondService.getList();
		modelAndView.addObject("luF", luF);
		
		modelAndView.addObject("log", log);
		modelAndView.setViewName("contents");
		
		return modelAndView;
	}
	
}

package com.mybatis.joongnam3;

import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mybatis.service.CategoryService;
import mybatis.service.InformationBoardService;
import mybatis.service.UserService;
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
public class InformationBoardController {
	private static final Logger logger = LoggerFactory.getLogger(InformationBoardController.class);
	
	@Autowired
	InformationBoardService service;
	@Autowired
	CategoryService categoryService;
	@Autowired
	UserService userService;

	@RequestMapping("informationboard.do")
	public ModelAndView informationboard(Locale locale,HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome informationboard! The client locale is {}.", locale);
		
		ModelAndView modelAndView = new ModelAndView();

		int cate = Integer.parseInt(request.getParameter("category"));
		Category category = categoryService.showCategory(cate);
		int totalCount = Integer.parseInt(request.getParameter("totalCount"));
		int page = Integer.parseInt(request.getParameter("page"));
		int idx = 1;
		try{
			idx =  Integer.parseInt(request.getParameter("idx"));
		} catch(Exception e){
			idx = 1;
		}
		
		//	���� �� board_id�� ��������
		int prevIdx=idx-1;
		for(int i=prevIdx;i>0;i--){
			try {
				HashMap<String, Integer> m = new HashMap<String, Integer>();
				m.put("con_no", i);
				m.put("category_no", category.getCategory_no());
				prevIdx = service.showBoard(m).getCon_no();
				break;
			} catch (Exception e) {
			}
		}
		
		//	���� �� board_id�� ��������
		int nextIdx=idx+1;
		for(int j=nextIdx;j<=totalCount;j++){
			try {
				HashMap<String, Integer> m = new HashMap<String, Integer>();
				m.put("con_no", j);
				m.put("category_no", category.getCategory_no());
				nextIdx = service.showBoard(m).getCon_no();
				break;
			} catch (Exception e) {
			}
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
		int min = service.min(cate);
		int max = service.max(cate);
		
		modelAndView.addObject("totalCount", totalCount);
		modelAndView.addObject("min", min);
		modelAndView.addObject("max", max);
		modelAndView.addObject("prevIdx", prevIdx);
		modelAndView.addObject("nextIdx", nextIdx);
		modelAndView.addObject("currentIdx", idx);
		modelAndView.addObject("currentPage", page);
		modelAndView.addObject("category", category);
		modelAndView.addObject("bo", board);
		modelAndView.setViewName("informationboard");
		
		return modelAndView;
	}
}

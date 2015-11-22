package com.mybatis.joongnam3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mybatis.service.CategoryService;
import mybatis.service.HobbyBoardService;
import mybatis.service.SelectHobbyListService;
import mybatis.util.ListUtil;
import mybatis.vo.Category;
import mybatis.vo.HobbyBoard;
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
public class HobbyBoardListController {
	
	private static final Logger logger = LoggerFactory.getLogger(HobbyBoardListController.class);

	@Autowired
	SelectHobbyListService selectListService;
	@Autowired
	HobbyBoardService service;
	@Autowired
	CategoryService categoryService;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws IOException 
	 */
	@RequestMapping("hobbyboardlist.do")
	public ModelAndView hobbyboardlist(Locale locale,HttpServletRequest request,HttpServletResponse response) throws IOException {
		logger.info("Welcome HobbyBoardList! The client locale is {}.", locale);
        
		ModelAndView modelAndView = new ModelAndView();
		Category category = categoryService.showCategory(Integer.parseInt(request.getParameter("category")));

		int currentPage = 1;
		int idx = 0;
		try{
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch(Exception e){
			currentPage = 1;
		}
		try {
			idx = Integer.parseInt(request.getParameter("idx"));
		} catch (Exception e) {
			idx = 0;
		}

		//	hobbyboardwrite
		int confirm = 0;
		try {
			confirm = Integer.parseInt(request.getParameter("confirm"));
		} catch (Exception e) {
			confirm = 0;
		}

		if (confirm == 1) {
			HobbyBoard board = new HobbyBoard();
			board.setCategory_no(Integer.parseInt(request.getParameter("category")));
			board.setM_no(Integer.parseInt(request.getParameter("m_no")));
			board.setContent(request.getParameter("content"));
			board.setPassword(request.getParameter("board_pass"));
			board.setTitle(request.getParameter("title"));
			board.setM_name(request.getParameter("name"));

			service.insert(board);
		}
		//	boardupdateOk
		else if(confirm == 2){
			System.out.println("Update?");
			HashMap<String, Integer> m = new HashMap<String, Integer>();
			m.put("con_no", idx);
			m.put("category_no", category.getCategory_no());
			String password = request.getParameter("uboard_pass");
			if(service.showBoard(m).getPassword().equals(password)){
				System.out.println("Update!");
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("title", request.getParameter("utitle"));
				map.put("content", request.getParameter("ucontent"));
				map.put("con_no", idx);
	
				service.update(map);
			}else{
				System.out.println("Fail");
			}
		}
		//	boarddeleteOk
		else if(confirm == 3){
			System.out.println("Delete?");
			HashMap<String, Integer> m = new HashMap<String, Integer>();
			m.put("con_no", idx);
			m.put("category_no", category.getCategory_no());
			String password = request.getParameter("dboard_pass");
			if(service.showBoard(m).getPassword().equals(password)){
				System.out.println("Delete!");
				service.delete(idx);
			}else{
				System.out.println("Fail");
			}
		}
		/////////////////////////////////////
		ListUtil lu = selectListService.getList(currentPage, category.getCategory_no());
		
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
		
		modelAndView.addObject("category", category);
		modelAndView.addObject("lu", lu);
		modelAndView.setViewName("hobbyboardlist");
		
		if(idx != 0 && (confirm != 2 && confirm !=3))
			response.sendRedirect("hobbyboard");
		
		return modelAndView;
	}
	
}

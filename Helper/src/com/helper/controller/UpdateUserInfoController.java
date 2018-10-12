package com.helper.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.helper.pojo.User;
import com.helper.service.UserService;

@Controller
public class UpdateUserInfoController {

	@Resource
	private UserService userService ;
	
	@RequestMapping("/UpdateUserInfoServlet")
	public String response (HttpServletRequest request) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		User localUser = (User)(request.getSession().getAttribute("localUser")) ;
		String phone = request.getParameter("phone") ;
		String sex = request.getParameter("sex") ;
		
		localUser.setPhone(phone);
		localUser.setSex(sex);
		
		try {
			if (userService.updateUser(localUser)) {
				//修改成功
				request.setAttribute("info", "修改成功") ;	
				request.setAttribute("needShowResult", true) ;	
			} else {
				//修改失败
				request.setAttribute("info", "修改失败，请重试") ;	
				request.setAttribute("needShowResult", true) ;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String refererUrl = request.getHeader("referer").toString() ;
		String refere = refererUrl.substring(refererUrl.lastIndexOf("/")+1, refererUrl.length()) ;
		return "forward:/" + refere ;
	}
}

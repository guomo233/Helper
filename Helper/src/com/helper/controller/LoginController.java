package com.helper.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.helper.pojo.User;
import com.helper.service.UserService;

@Controller
public class LoginController {
	
	@Resource
	private UserService userService ;
	
	@RequestMapping("/LoginServlet")
	public String response (HttpServletRequest request) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username") ;
		String password = request.getParameter("password") ;
		
		try {
			User user = userService.login(username, password) ;
			if (user != null) {
				request.getSession().setAttribute("localUser", user) ;
				//登录成功
				return "redirect:/SelectServlet" ;
				
			} else {
				//登录失败
				request.setAttribute("info", "登录失败，请确定账号密码") ;	
				request.setAttribute("needShowResult", true) ;	
				return "forward:/SelectServlet" ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null ;
	}
    
}

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
public class RegisterController {

	@Resource
	private UserService userService ;
	
	@RequestMapping("/RegisterServlet")
	public String response (HttpServletRequest request) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		User user = new User () ;
		user.setUsername(request.getParameter("username")) ;
		user.setPassword(request.getParameter("password")) ;
		user.setPhone(request.getParameter("phone")) ;
		user.setSex(request.getParameter("sex")) ;
		user.setFinishTimes(0);
		user.setEvaluate(0);
		
		String confirmPassword = request.getParameter("confirmPassword") ;
		if (!confirmPassword.equals(user.getPassword())) {
			//注册失败，密码不一致
			request.setAttribute("info", "注册失败，密码不一致，请重新确认") ;	
			request.setAttribute("needShowResult", true) ;	
		} else {
			try {
				if (userService.register(user)) {
					//注册成功
					request.setAttribute("info", "注册成功") ;	
					request.setAttribute("needShowResult", true) ;	
				} else {
					//注册失败
					request.setAttribute("info", "注册失败，请确认信息格式") ;	
					request.setAttribute("needShowResult", true) ;	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return "forward:/SelectServlet" ;
	}
}

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
public class UpdatePasswordController {

	@Resource
	private UserService userService ;
	
	@RequestMapping("/UpdatePasswordServlet")
	public String response (HttpServletRequest request) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		User localUser = (User)(request.getSession().getAttribute("localUser")) ;
		String password = request.getParameter("password") ;
		String confirmPassword = request.getParameter("confirmPassword") ;
		
		if (!password.equals(confirmPassword)) {
			//修改失败，密码不一致
			request.setAttribute("info", "修改失败，密码不一致") ;	
			request.setAttribute("needShowResult", true) ;
		} else {
			try {
				localUser.setPassword(password);
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
		}
		
		String refererUrl = request.getHeader("referer").toString() ;
		String refere = refererUrl.substring(refererUrl.lastIndexOf("/")+1, refererUrl.length()) ;
		return "forward:/" + refere ;
	}
}

package com.helper.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.helper.pojo.User;
import com.helper.service.TaskService;

@Controller
public class ReceiveController {

	@Resource
	private TaskService taskService ;
	
	@RequestMapping("/ReceiveServlet")
	public String response (HttpServletRequest request) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String taskId = request.getParameter("taskId") ;
		User localUser = (User)(request.getSession().getAttribute("localUser")) ;
		
		try {
			if (taskService.receiveTask(Integer.parseInt(taskId), localUser.getUsername())) {
				//接受成功
				request.setAttribute("info", "已接受") ;	
				request.setAttribute("needShowResult", true) ;	
			} else {
				//接受失败
				request.setAttribute("info", "操作失败，请重试") ;	
				request.setAttribute("needShowResult", true) ;	
			}
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		String refererUrl = request.getHeader("referer").toString() ;
		String refere = refererUrl.substring(refererUrl.lastIndexOf("/")+1, refererUrl.length()) ;
		return "forward:/" + refere ;
	}
}

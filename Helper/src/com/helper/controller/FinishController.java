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
public class FinishController {

	@Resource
	private TaskService taskService ;
	
	@RequestMapping("/FinishServlet")
	public String response (HttpServletRequest request) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String taskId = request.getParameter("taskId") ;
		User localUser = (User)(request.getSession().getAttribute("localUser")) ;
		int evaluate = Integer.parseInt(request.getParameter("evaluate")) ;
				
		try {
			if (taskService.finishTask(Integer.parseInt(taskId), localUser.getUsername(), evaluate)) {
				//完成成功
				request.setAttribute("info", "任务已完成") ;	
				request.setAttribute("needShowResult", true) ;	
				
			} else {
				//完成失败
				request.setAttribute("info", "操作失败，请重试") ;	
				request.setAttribute("needShowResult", true) ;	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String refererUrl = request.getHeader("referer").toString() ;
		String refere = refererUrl.substring(refererUrl.lastIndexOf("/")+1, refererUrl.length()) ;
		return "forward:/" + refere ;
	}
	
}

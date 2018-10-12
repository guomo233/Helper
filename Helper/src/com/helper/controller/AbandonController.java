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
public class AbandonController {

	@Resource
	private TaskService taskService ;
	
	@RequestMapping("/AbandonServlet")
	public String response (HttpServletRequest request) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String taskId = request.getParameter("taskId") ;
		User localUser = (User)(request.getSession().getAttribute("localUser")) ;
		
		try {
			if (taskService.abandonTask(Integer.parseInt(taskId), localUser.getUsername())) {
				//放弃成功
				request.setAttribute("info", "已放弃此任务") ;	
				request.setAttribute("needShowResult", true) ;	
			} else {
				//放弃失败
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

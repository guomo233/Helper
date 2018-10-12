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
public class DeleteController {

	@Resource
	private TaskService taskService ;
	
	@RequestMapping("/DeleteServlet")
	public String response (HttpServletRequest request) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String taskId = request.getParameter("taskId") ;
		User localUser = (User)(request.getSession().getAttribute("localUser")) ;
		
		try {
			if (taskService.deleteTask(Integer.parseInt(taskId))) {
				//删除成功
				request.setAttribute("info", "已删除此任务") ;	
				request.setAttribute("needShowResult", true) ;	
			} else {
				//删除失败
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

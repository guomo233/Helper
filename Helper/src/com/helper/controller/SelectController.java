package com.helper.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.helper.pojo.Task;
import com.helper.pojo.User;
import com.helper.service.TaskService;

@Controller
public class SelectController {

	@Resource
	private TaskService taskService ;
	
	@RequestMapping("/SelectServlet")
	public String response (HttpServletRequest request) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String requesterString = request.getParameter("requester") ;
		int requester = requesterString == null ? 0 : Integer.parseInt(requesterString) ;
		User localUser = (User)(request.getSession().getAttribute("localUser")) ;
		
		//根据条件获取任务
		List<Task> taskList = null ;
		try {
			taskList = taskService.selectTasks (requester, localUser == null ? null : localUser.getUsername());
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		//转发到jsp
		request.setAttribute("taskList", taskList) ;
		request.setAttribute("requester", requester) ;
		if (requester == 0) {
			return "forward:/Main.jsp" ;
		} else {
			return "forward:/MyTask.jsp" ;
		}
	}
}

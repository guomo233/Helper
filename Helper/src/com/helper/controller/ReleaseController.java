package com.helper.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.helper.pojo.Task;
import com.helper.pojo.User;
import com.helper.service.TaskService;

@Controller
public class ReleaseController {

	@Resource
	private TaskService taskService ;
	
	@RequestMapping("/ReleaseServlet")
	public String response (HttpServletRequest request) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		Task task = new Task () ;
		User localUser = (User)(request.getSession().getAttribute("localUser")) ;
		task.setCity(request.getParameter("city"));
		task.setBeginPostion(request.getParameter("beginPosition"));
		task.setEndPosition(request.getParameter("endPosition"));
		try {
			task.setBeginTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("beginTime")));
			task.setEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("endTime")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		task.setRemark(request.getParameter("remark")) ;
		task.setDemand(request.getParameter("demand"));
		task.setStatus(0);
		task.setPay(Double.parseDouble(request.getParameter("pay"))) ;
		task.setReceiveUsername(null);
		task.setReleaseUsername(localUser.getUsername());
		task.setUpdateTime(new Date());
		
		try {
			if (taskService.addTask(task, localUser.getUsername())) {
				//发布成功
				request.setAttribute("info", "发布成功") ;	
				request.setAttribute("needShowResult", true) ;	
			} else {
				//发布失败
				request.setAttribute("info", "发布失败，请确认信息格式") ;	
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

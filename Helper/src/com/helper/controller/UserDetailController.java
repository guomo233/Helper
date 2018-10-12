package com.helper.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.helper.pojo.Recording;
import com.helper.pojo.User;
import com.helper.service.RecordingService;
import com.helper.service.UserService;

@Controller
public class UserDetailController {

	@Resource
	private UserService userService ;
	
	@Resource
	private RecordingService recordingService ;
	
	@RequestMapping("/UserDetailServlet")
	public String response (HttpServletRequest request) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username") ;
		
		User user = null ;
		List<Recording> recordingList = null ;
		try {
			user = userService.selectUser(username) ;
			recordingList = recordingService.selectRecording(username) ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("user", user) ;
		request.setAttribute("recordingList", recordingList);
		return "forward:/UserDetailJsp.jsp" ;
	}
}
	

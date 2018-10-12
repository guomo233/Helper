package com.helper.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.helper.pojo.Massage;
import com.helper.pojo.User;
import com.helper.service.MassageService;

@Controller
public class SelectMassageController {

	@Resource
	MassageService massageService ;
	
	@RequestMapping("/SelectMassageServlet")
	public String response (HttpServletRequest request) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int requester = Integer.parseInt(request.getParameter("requester")) ;
		
		User localUser = (User)(request.getSession().getAttribute("localUser")) ;
		
		List<Massage> massageList = null ;
		try {
			massageList = massageService.selectMassages(requester, localUser.getUsername()) ;
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		//转发到jsp
		request.setAttribute("massageList", massageList) ;
		request.setAttribute("requester", requester) ;
		return "forward:/MyMassage.jsp" ;
	}
	
}

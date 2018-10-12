package com.helper.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.helper.pojo.Massage;
import com.helper.pojo.User;
import com.helper.service.MassageService;

@Controller
public class SendMassageController {

	@Resource
	private MassageService massageService ;
	
	@RequestMapping("/SendMassageServlet")
	public String response (HttpServletRequest request) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		Massage massage = Massage.getEmptyMassage() ;
		User localUser = (User)(request.getSession().getAttribute("localUser")) ;
		
		massage.setSenderUsername(localUser.getUsername()) ;
		massage.setTargetUsername(request.getParameter("targetUsername"));
		massage.setTitle(request.getParameter("title"));
		massage.setContent(request.getParameter("content"));
		massage.setSkimed(false);
		massage.setSendTime(new Date());
		
		try {
			if (massageService.sendMassage(massage)) {
				//发送成功
				request.setAttribute("info", "已发送") ;	
				request.setAttribute("needShowResult", true) ;	
			} else {
				//发送失败
				request.setAttribute("info", "发送失败，请重试") ;	
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

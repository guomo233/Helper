package com.helper.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.helper.service.TaskService;

@Controller
@RequestMapping("/test")

public class TestController {
	
	@Resource  
    private TaskService taskService;

	@RequestMapping("/test")
	public String toIndex(HttpServletRequest request,Model model){  
        
        return "Main";
	}
}

package com.hs.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {
	
	@RequestMapping("courses")
	public String courses(HttpServletRequest request) {
		
		HttpSession httpSession = request.getSession();
		
		String textInUrl = request.getParameter("param-name");
		
		System.out.println("Print param-name : " + textInUrl);
		
		httpSession.setAttribute("textInUrl", textInUrl);
		
		return "course";
		
	}

}

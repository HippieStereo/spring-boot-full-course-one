package com.hs.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {
	
	@RequestMapping("courses-one")
	public String coursesOne(HttpServletRequest request) {
		
		HttpSession httpSession = request.getSession();
		
		String textInUrl = request.getParameter("param-name");
		
		System.out.println("Print param-name : " + textInUrl);
		
		httpSession.setAttribute("textInUrl", textInUrl);
		
		return "course";
		
	}
	
	@RequestMapping("courses-two")
	public String coursesTwo(@RequestParam("name") String textInUrl, HttpSession session) {
		
		System.out.println("Print param-name : " + textInUrl);
		
		session.setAttribute("textInUrl", textInUrl);
		
		return "course";
		
	}
	
	@RequestMapping("courses-three")
	public ModelAndView coursesThree(@RequestParam("name") String textInUrl) {
		
		System.out.println("Print param-name : " + textInUrl);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("textInUrl", textInUrl);
		modelAndView.setViewName("course");
		
		return modelAndView;
		
	}

}

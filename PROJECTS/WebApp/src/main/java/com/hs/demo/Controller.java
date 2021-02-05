package com.hs.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {
	
	@RequestMapping("courses")
	public String courses() {
		
		System.out.println("Welcome !!!");
		
		return "course";
		
	}

}

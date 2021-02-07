package com.hs.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

	@GetMapping("customer")
	public String customerForm() {
		
		return "customer";
		
	}
	
	@PostMapping("result")
	public String viewResult(@RequestParam("cid") String cid, @RequestParam("cname") String cname, 
			@RequestParam("cemail") String cemail, ModelMap model){
		
		model.addAttribute("cid", cid);
		model.addAttribute("cname", cname);
		model.addAttribute("cemail", cemail);
		
		System.out.println(cid + " " + cname + " " + cemail);
		
		return "result";
		
	}
	
}

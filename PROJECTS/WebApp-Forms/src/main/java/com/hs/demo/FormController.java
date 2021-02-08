package com.hs.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	
	@Autowired
	CustomerRepo repo;

	@RequestMapping("/")
	public String homeForm() {
		
		return "form";
		
	}
	
	@RequestMapping("/putInDB")
	public String customerForm(Customer customer) {
		
		repo.save(customer);
		
		return "form";
		
	}
	
	@RequestMapping("/result")
	public String customerForm() {
		
		return "result";
		
	}
	
	@GetMapping("/retrieve")
	public ModelAndView viewResult(@RequestParam("cid") int cid){
		
		ModelAndView mv = new ModelAndView("retrieve");
		
		Customer customer = repo.findById(cid).orElse(null);
		
		mv.addObject(customer);
		
		return mv;
		
	}
	
	@RequestMapping("/customers")
	@ResponseBody
	public String allCustomers(){
		
		return repo.findAll().toString();
		
	}
	
}

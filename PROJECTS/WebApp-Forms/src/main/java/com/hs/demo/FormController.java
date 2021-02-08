package com.hs.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public List<Customer> allCustomers(){
		
		return repo.findAll();
		
	}
	
	@RequestMapping("/customers/{cid}")
	@ResponseBody
	public Optional<Customer> customerById(@PathVariable int cid){
		
		return repo.findById(cid);
		
	}
	
	@PostMapping("/customers")
	public Customer customerNew(@RequestBody Customer customer){
		
		repo.save(customer);
		
		return customer;
		
	}
	
	@DeleteMapping("/customers/{cid}")
	public Customer customerDeletById(@PathVariable int cid){
		
		Customer customer = repo.getOne(cid);

		repo.delete(customer);
		
		return customer;
		
	}
	
	@PutMapping("/customers")
	public Customer customerUpdate(@RequestBody Customer customer){
		
		repo.save(customer);
		
		return customer;
		
	}
	
	@PutMapping(path="/customersJson", consumes= {"application/json"})
	public Customer customerUpdateJson(@RequestBody Customer customer){
		
		repo.save(customer);
		
		return customer;
		
	}
	
}

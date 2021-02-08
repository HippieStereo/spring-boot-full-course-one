package com.hs.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	//Optional<Customer> findById(int cid);
	
}

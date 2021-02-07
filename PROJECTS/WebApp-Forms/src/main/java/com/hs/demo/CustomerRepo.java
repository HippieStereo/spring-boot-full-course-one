package com.hs.demo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Integer>{

	Optional<Customer> findById(int cid);
	
}

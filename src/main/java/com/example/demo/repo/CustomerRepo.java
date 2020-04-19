package com.example.demo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

@Repository
public interface CustomerRepo extends MongoRepository<Customer, String>{
	
	public Customer findByUsername(String username);
 
	

}

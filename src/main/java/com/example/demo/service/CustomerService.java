package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	public String signup(String username, String fname,String lname, int age, String gender,String password) {
		
		String status="";
		
	try {
		Customer customer= customerRepo.findByUsername(username);
		if(customer.getUsername().equals(username)) {
		status="user already exist";
		}
	}catch(Exception e) {
		
		customerRepo.save(new Customer(username, fname, lname, age, gender, password));
		status="Success";
	}
	
	return status;
	
		
	}

	
	public boolean signin(String username,String password) {
		
		try {
	   Customer customer= customerRepo.findByUsername(username);
	   
	   if(customer.getPassword().equals(password)){
		   
		   return true;
	   }else {
		   return false;
	   }
		}catch (Exception e) {
			return false;
		}
		
	}
	
	
	public  List<Customer> getAllCustomers(){
		
		return customerRepo.findAll();
		
	}
	
	public Customer getCutomer(String username) {
		
		return customerRepo.findByUsername(username);
	}
	
	public String updateCustomer(String username, String fname,String lname, int age, String gender,String password) {
		
		String status;
		
		try {
			if(customerRepo.findByUsername(username).getUsername().equals(username)) {
				
				Customer customer=customerRepo.findByUsername(username);
				customer.setAge(age);
				customer.setFname(fname);
				customer.setLname(lname);
				customer.setGender(gender);
				customer.setPassword(password);
				
				customerRepo.save(customer);
				
				status="Success";
				
			}else {
				status="Unsuccess";
			}
		}catch (Exception e) {
			status="User donot exist";
		}

			return status;
		
	}
	
	public String deleteCustomer(String username, String password) {
		
		String status="";
		try {
			if(customerRepo.findByUsername(username).equals(username) && customerRepo.findByUsername(password).equals(password)) {
				status="Success";
				
				Customer customer=customerRepo.findByUsername(username);
				customerRepo.delete(customer);
				
			}else {
				status="Username or password is Incorrect";
			}
			
		}catch (Exception e) {
			status="user do not exist";
	
		}
		return status;
	}
	
	
	
}

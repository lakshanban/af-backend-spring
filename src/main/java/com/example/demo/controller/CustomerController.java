package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	
	@RequestMapping("/test")
	public String test(){
		
		return "fuck you man ";
	} 
	
	@RequestMapping("/signupcustomer")
	public String signup(@RequestParam String username,@RequestParam String fname,@RequestParam String lname,@RequestParam int age,@RequestParam String gender,@RequestParam String password){
		
		 String status=customerService.signup(username, fname, lname, age, gender, password);
		 
		 return status;
	} 
	
	@PostMapping("/signincustomer")
	public boolean signin(@RequestParam String username,@RequestParam String password) {
		System.out.println(username+"    "+password);
		return customerService.signin(username, password);
	}
	
	@RequestMapping("/getallcustomers")
	public List<Customer> getAllCustomers(){
		
		return customerService.getAllCustomers();
	}
	
	@RequestMapping("/getcustomer")
	public Customer getCustomer(@RequestParam String username) {
		
		return customerService.getCutomer(username);
		
	}
	
	@RequestMapping("/updatecustomer")
	public String updateCustomer(@RequestParam String username,@RequestParam String fname,@RequestParam String lname,@RequestParam int age,@RequestParam String gender,@RequestParam String password) {
		
		return customerService.updateCustomer(username, fname, lname, age, gender, password);
		
	}
	
	@RequestMapping("/deletecustomer")
	public String deletecustomer(@RequestParam String username,@RequestParam String password) {
		
		return customerService.deleteCustomer(username, password);
	}
	
	
}

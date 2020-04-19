package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepo;
import com.example.demo.repo.ProductsPendingQueueRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	ProductsPendingQueueRepo pendingqueue;
	
	
	public String  addFromQueue(String pname) {
		try {
		productRepo.save(pendingqueue.findBypname(pname));
		
		
		return "Success";
		
		}catch (Exception e) {
			return "User Do not Exist";
		}
	}
	

	
	public Product getProductByname(String pname) {
		return productRepo.findBypname(pname);
		
		
	}
	
	public List<Product> getAllProducts(){
		
		return productRepo.findAll();
		
	}
	
	public List<Product> getAllProductsByOwner(String powner){
		
	       List<Product> list= productRepo.findAll();
	       List<Product> out= new ArrayList<>();
	       
	       for(Product p: list) {
	    	   
	    	   if(p.getPowner().equals(powner)) {
	    		   out.add(p);
	    	   }
	       }
	       
	       return out;
		
	}
		
	
	public List<Product> getAllProductsByGender(String pgender){
		
	     List<Product> list= productRepo.findAll();
	       List<Product> out= new ArrayList<>();
	       
	       for(Product p: list) {
	    	   
	    	   if(p.getPgender().equals(pgender)) {
	    		   out.add(p);
	    	   }
	       }
	       
	       return out;
		
	}
	
	public List<Product> getAllProductsByCategory(String pcategory){
		
	     List<Product> list= productRepo.findAll();
	       List<Product> out= new ArrayList<>();
	       
	       for(Product p: list) {
	    	   
	    	   if(p.getPcategory().equals(pcategory)) {
	    		   out.add(p);
	    	   }
	       }
	       
	       return out;
		
	}
	

}

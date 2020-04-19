package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductsPendingQueueRepo;

@Service
public class ProductPendingQueueService {

	@Autowired
	private ProductsPendingQueueRepo productqueue;
	
	public String AddToQueue(String pname,String pdescription, String pcategory,String pgender,String powner,double pprice,String[] pphotos) {
		String status="";
		try {
			if(productqueue.findBypname(pname).getPname().equals(pname)){
			  status="Unsuccess";	
			}
			}catch(Exception e) {
				status="Success";
				productqueue.save(new Product(pname, pdescription, pcategory,pgender, powner, pprice, pphotos));
			}
			
			return status;
		}
	
	
	public Product getProductByname(String pname) {
		return productqueue.findBypname(pname);
		
		
	}
	
	public List<Product> getAllProducts(){
		
		return productqueue.findAll();
		
	}
	
	public List<Product> getAllProductsByOwner(String powner){
		
		List<Product> list=productqueue.findAll();
		List<Product> out=new ArrayList<>();
		
		for(Product p: list) {
			if(p.getPowner().equals(powner)) {
				out.add(p);
			}
		}
		return out;
	}
	
}

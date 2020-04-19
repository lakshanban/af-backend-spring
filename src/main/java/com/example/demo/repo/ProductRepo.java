package com.example.demo.repo;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;

@Repository
public interface ProductRepo extends MongoRepository<Product,String> {
	
	public Product findBypname(String pname);
	


}

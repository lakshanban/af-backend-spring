package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductPendingQueueService;
import com.example.demo.service.ProductService;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class productController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductPendingQueueService pendingService;
	
	//////////////////////////////product pending Queue///////////////////////////////////////
	
	@RequestMapping("/addproduct")
	public String AddProductToTheQueue(@RequestParam String pname,@RequestParam String pdescription,@RequestParam String pcategory, @RequestParam String pgender,@RequestParam String powner,@RequestParam double pprice,@RequestParam String[] pphotos)
	{
		return pendingService.AddToQueue(pname, pdescription, pcategory, pgender, powner, pprice, pphotos);
		
	}
	

	@RequestMapping("/showproductqueue")
	public List<Product> showproductQueue(){
		return pendingService.getAllProducts();
	}

	@RequestMapping("/getqueueproduct")
	public Product getqueueProduct(@RequestParam String pname) {
		return pendingService.getProductByname(pname);
	}
	
	@RequestMapping("/getallqueueproductsbyowner")
	public List<Product> getAllQueueProductsByOwner(@RequestParam String powner){
		
		return pendingService.getAllProductsByOwner(powner);
	}
	
	////////////////////////product service //////////////////////////////////////////////
	
	@RequestMapping("/getproduct")
	public Product getProductByName(@RequestParam String pname) {
		return productService.getProductByname(pname);
	}
	
	@RequestMapping("/addfromqueue")
	public String addfromQueue(@RequestParam String pname) {
		
		return productService.addFromQueue(pname);
	}
	
	@RequestMapping("/getallproducts")
	public List<Product> getAllproducts(){
		return productService.getAllProducts();
	}
	
	@RequestMapping("/getallproductsbyowner")
	public List<Product> getAllProductsByOwner(@RequestParam String powner){
		
		return productService.getAllProductsByOwner(powner);
	}
	
	
	@RequestMapping("/getallproductbycategory")
	public List<Product> getAllProductsByCategory(@RequestParam String pcategory){
		return productService.getAllProductsByCategory(pcategory);
	}
	
	@RequestMapping("/getallproductbygender")
	public List<Product> getAllProductsByGender(@RequestParam String pgender){
		return productService.getAllProductsByGender(pgender);
	}
}

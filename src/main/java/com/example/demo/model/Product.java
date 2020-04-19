package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	
	
	@Id
	private String ID;

	private String pname;
	private String pdescription;
	private String pcategory;
	private String pgender;
	private double pprice;
	private String powner;
	private String[] pphotos;
	
	
	public Product(String pname,String pdescription,String pcategory,String pgender,String powner,double pprice, String[] pphotos) {
		this.pname=pname;
		this.pdescription=pdescription;
		this.pcategory=pcategory;
		this.pgender=pgender;
		this.pprice=pprice;
		this.pphotos=pphotos;
		this.powner=powner;
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getPdescription() {
		return pdescription;
	}


	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}


	public String getPcategory() {
		return pcategory;
	}


	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}


	public double getPprice() {
		return pprice;
	}


	public void setPprice(double pprice) {
		this.pprice = pprice;
	}


	public String[] getPphotos() {
		return pphotos;
	}


	public void setPphotos(String[] pphotos) {
		this.pphotos = pphotos;
	}


	public String getPowner() {
		return powner;
	}


	public void setPowner(String powner) {
		this.powner = powner;
	}


	public String getPgender() {
		return pgender;
	}


	public void setPgender(String pgender) {
		this.pgender = pgender;
	}
	
	
	
	
	
	
}

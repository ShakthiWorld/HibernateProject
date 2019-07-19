package com.visa.training.jpa.app;

import java.util.List;

import com.visa.training.jpa.dal.JpaProductDAO;
import com.visa.training.jpa.domain.Product;

public class JpaProductApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JpaProductDAO dao=new JpaProductDAO(); 
		
		  Product test=new Product("abc", 100,10); 
		  Product saved=dao.save(test); 
		  System.out.println(saved.toString());
		  dao.remove(saved.getId());
		  saved.setName("def"); 
		  dao.update(saved);
		 
		 
		
		
		List<Product> products=dao.findAll();
		products.forEach(System.out::println);
		products=dao.findByPriceGreaterThan(500);
		products.forEach(System.out::println);
		
		System.exit(0);
	}

}

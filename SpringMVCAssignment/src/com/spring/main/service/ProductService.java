package com.spring.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.main.DB.ProductDB;
import com.spring.main.model.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductDB productDB;

	public List<Product> fetchAllProducts() {
		List<Product> list = productDB.fetchAllProducts();
		return list;
	}

	public void insertProduct(Product product) {
		productDB.insertProduct(product);
	}

	public void deleteProductById(int id) {
		
		productDB.deleteProductById(id);
		
	}

	public void updateProductById(Product product) {
		productDB.updateProductById(product);
	}


}

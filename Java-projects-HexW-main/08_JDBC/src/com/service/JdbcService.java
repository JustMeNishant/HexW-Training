package com.service;

import java.util.List;
import com.model.Product;
import com.service.ProductDB;

public class JdbcService
{
    static ProductDB productDB;
    
    public JdbcService() {
        this.productDB = new ProductDB();
    }
    
    public void insert(final Product product) {
        this.productDB.insert(product);
    }
        
    public List<Product> fetchProduct() {
        return (List<Product>)this.productDB.fetchProducts();
    }

	public static void deleteProduct(int id) {
		// TODO Auto-generated method stub
		
		productDB.delete(id);
	}

	

	}

package com.main;

import java.util.List;
import java.util.Scanner;

import com.model.Product;
import com.service.JdbcService;

public class App {
	public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        final JdbcService productService = new JdbcService();
        while(true) {
        System.out.println("*****JDBC******");
        System.out.println("1. Insert product");
        System.out.println("2. Delete product by ID");
        System.out.println("3. Display all product");
        System.out.println("4. Exit");
        int input = sc.nextInt();
    
        	switch (input) {
        
            case 1: {
                System.out.println("Enter product Details");
                System.out.println("Product Name: ");
                final String name = sc.next();
                System.out.println("Prouct Price: ");
                final double price = sc.nextDouble();
                System.out.println("Product Description: ");
                final String desc = sc.next();
                final Product product = new Product();
                product.setName(name);
                product.setPrice(price);
                product.setDescrib(desc);
                productService.insert(product);
                System.out.println("product Record Inserted.. ");
                break;
            }
            case 2: {
            	System.out.println("******Delete product********"); 
            	System.out.println("Enter the ID of product to delete"); 
            	int id = sc.nextInt();
            	JdbcService.deleteProduct(id);
            	System.out.println("product Record deleted from Table..."); 
            	break;
            }
            case 3: {
                System.out.println("******Display all products******");
                final List<Product> list = (List<Product>)productService.fetchProduct();
                for (final Product e : list) {
                    System.out.println(e);
                }
                break;
            }
            case 4: return;
            default:  System.out.println("Invalid Entry"); 
            break;
            }
        	
            }
            }
}

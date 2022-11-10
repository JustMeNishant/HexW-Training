package com.mybootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybootapp.model.Product;
import com.mybootapp.model.Vendor;
import com.mybootapp.repository.ProductRepository;
import com.mybootapp.repository.VendorRepository;

@RestController
public class ProductController {
	
	@Autowired
	ProductRepository productrepository;
	@Autowired
	VendorRepository vendorRepository;
	
	@PostMapping("/product/insert")
	public Product insertProduvt(@RequestBody Product product) {
		Vendor vendor = new Vendor();
		Vendor vendorDB = vendorRepository.findByName(product.getVendor().getName());
		
		if(vendorDB == null) {
			vendor = product.getVendor();
		}
		else {
			vendor = vendorDB;
		}
		vendor = vendorRepository.save(vendor);
		product.setVendor(vendor);
		return productrepository.save(product);
	}

	@GetMapping("/vendor/product/{pname}")
	public Vendor getVendorNameByProductName(@PathVariable("pname") String pname) {
		Vendor vendor=productrepository.getVendorNameByProductName(pname);
		System.out.println(vendor);
		return vendor;
	}
}

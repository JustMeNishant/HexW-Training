package com.spring.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.main.model.Product;
import com.spring.main.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productservice; 
	
	@Autowired
	private Product product;

	@RequestMapping("/")
	public String showAllProducts() {
		
		return "redirect:redirect-product";
	}
		
	@RequestMapping("/delete-product")
	public String deleteProduct(@RequestParam("id") int id,Model model) {
		productservice.deleteProductById(id);
		return "redirect:redirect-product";
	}
	
	@RequestMapping("/editproduct-page")
	public String editProduct(@RequestParam("id") int id,Model model) {
		System.out.println("========"+id);
		List<Product> list= productservice.fetchAllProducts();
		for(Product p:list) {
			if(id == p.getId()) {
				product = p;
				break;
			}
		}
		model.addAttribute("product",product);
		
		return "edit-product";
	}
	@RequestMapping("update-product")
	public String updateProduct(@RequestParam("id") int id,
			   @RequestParam("title") String title, 
			   @RequestParam("ram") int ram, 
			   @RequestParam("memory") int memory ,
			   @RequestParam("display") String display,
			   @RequestParam("category") String category,
			   @RequestParam("price") double price,
			   Model model) {
		product.setId(id);
		product.setTitle(title);
		product.setRam(ram);
		product.setMemory(memory);
		product.setDisplay(display);
		product.setCategory(category);
		product.setPrice(price);		
		productservice.updateProductById(product);
		return "redirect:redirect-product";		
		
	}

	
	@RequestMapping("insertProduct-page")
	public String insertProductPage() {
		return "insert-product";
	}
	
	@RequestMapping("/insert-product")
	public String insertProduct(@RequestParam("title") String title, 
			   @RequestParam("ram") int ram, 
			   @RequestParam("memory") int memory ,
			   @RequestParam("display") String display,
			   @RequestParam("category") String category,
			   @RequestParam("price") double price,
			   Model model) {		
		product.setTitle(title);
		product.setRam(ram);
		product.setMemory(memory);
		product.setDisplay(display);
		product.setCategory(category);
		product.setPrice(price);
		productservice.insertProduct(product);			
		return "redirect:redirect-product";
	}
	
	@RequestMapping("/redirect-product")
	public String redirect(Model model) {

		List<Product> list = productservice.fetchAllProducts();
		model.addAttribute("list",list);
		return "vendor-home";
	}
}

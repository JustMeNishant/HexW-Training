package com.practiseapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practiseapp.Repository.BookRepository;
import com.practiseapp.model.Book;

@RestController
@CrossOrigin(origins = {"http://localhost:3929/"})
public class LMSController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/book/insert")
	public Book insertBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}
	
	@GetMapping("/book/get/all")
	public List<Book> getBook() {
		return bookRepository.findAll();
	}

}

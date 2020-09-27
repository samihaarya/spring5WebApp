package com.udemy_course.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy_course.spring5webapp.repositories.BookRepository;

@Controller
//our intend with this annotation is to make spring mvc controller
public class bookController {
	
	private final BookRepository bookRepo;
	
	public bookController(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	@RequestMapping("/books")
	public String getBooks(Model model) {
		
		model.addAttribute("books", bookRepo.findAll());
		return "books/list";
	}

	
	
}

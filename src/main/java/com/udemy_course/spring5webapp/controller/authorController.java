package com.udemy_course.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy_course.spring5webapp.repositories.AuthorRepository;

@Controller
public class authorController {

	private final AuthorRepository authorRepo;

	public authorController(AuthorRepository authorRepo) {
		this.authorRepo = authorRepo;
	}
	
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorRepo.findAll());
		return "authors/list";
	}
}

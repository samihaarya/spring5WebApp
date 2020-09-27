package com.udemy_course.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.udemy_course.spring5webapp.domain.Author;
import com.udemy_course.spring5webapp.domain.Book;
import com.udemy_course.spring5webapp.repositories.AuthorRepository;
import com.udemy_course.spring5webapp.repositories.BookRepository;



@Component
//tells spring to go ahead and detect this as spring managed component
public class BootStrapSpringData implements CommandLineRunner {

	private final AuthorRepository authorRepo;
	private final BookRepository bookRepo;
	
	public BootStrapSpringData(AuthorRepository authorRepo, BookRepository bookRepo) {
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
	}

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "123457");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepo.save(eric);
		bookRepo.save(ddd);
		
		Author rod = new Author("Rod","Jhonsen");
		Book noEJB= new Book("J2EE Development withoud EJB", "234567");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		authorRepo.save(rod);
		bookRepo.save(noEJB);
		
		System.out.println("Starting BootStrap Application");
		System.out.println("Number of Books "+ bookRepo.count());
		
	}


}

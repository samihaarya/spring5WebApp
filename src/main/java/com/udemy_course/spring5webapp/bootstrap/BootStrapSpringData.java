package com.udemy_course.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.udemy_course.spring5webapp.domain.Author;
import com.udemy_course.spring5webapp.domain.Book;
import com.udemy_course.spring5webapp.domain.Publisher;
import com.udemy_course.spring5webapp.repositories.AuthorRepository;
import com.udemy_course.spring5webapp.repositories.BookRepository;
import com.udemy_course.spring5webapp.repositories.PublisherRepository;



@Component
//tells spring to go ahead and detect this as spring managed component
public class BootStrapSpringData implements CommandLineRunner {

	private final AuthorRepository authorRepo;
	private final BookRepository bookRepo;
	private final PublisherRepository publisherRepo;
	
	public BootStrapSpringData(AuthorRepository authorRepo, BookRepository bookRepo, PublisherRepository publisherRepo) {
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
		this.publisherRepo= publisherRepo;
	}

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Starting BootStrap Application");

		Publisher pub= new Publisher("sam", "sham nagar", "Rajpura", "Punjab", "140401");
		publisherRepo.save(pub);
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "123457");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		pub.getBooks().add(ddd);
		ddd.setPublisher(pub);
		
		authorRepo.save(eric);
		bookRepo.save(ddd);
		publisherRepo.save(pub);
		
		Author rod = new Author("Rod","Jhonsen");
		Book noEJB= new Book("J2EE Development withoud EJB", "234567");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		pub.getBooks().add(noEJB);
		noEJB.setPublisher(pub);
		
		authorRepo.save(rod);
		bookRepo.save(noEJB);
		publisherRepo.save(pub);
		
		System.out.println("Number of Books "+ bookRepo.count());
		System.out.println("Number of Books by publisher "+ pub.getBooks().size());
	}


}

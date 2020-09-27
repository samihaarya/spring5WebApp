package com.udemy_course.spring5webapp.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="book_id")
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="isbn")
	private String isbn;
	
	@ManyToMany
	@JoinTable(name="author_book",joinColumns=@JoinColumn(name ="book_id"),
	inverseJoinColumns= @JoinColumn(name= "author_id"))
	private Set<Author> authors = new HashSet<>();
	
	public Book() {
		
	}
	
	public Book(String title, String isbn) {
		this.title= title;
		this.isbn= isbn;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + ", authors=" + authors + "]";
	}

	@Override
	public int hashCode() {
		return id != null?Objects.hash(id): 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Book book = (Book) obj;
		return id != null?Objects.equals(id, book.id) : book.id== null;
	}

}

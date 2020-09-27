package com.udemy_course.spring5webapp.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "author_id")
	private Long id;
	
	@Column(name= "first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
	@ManyToMany(mappedBy="authors")
	private Set<Book> books = new HashSet<>();
	
	public Author() {
		
	}
	
	public Author(String firstname, String lastname) {
		this.firstname= firstname;
		this.lastname= lastname;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public Set<Book> getBooks() {
		return books;
	}
	
	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}

	@Override
	public int hashCode() {
		return id != null?Objects.hash(id): 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author author = (Author) obj;
		return id != null?Objects.equals(id, author.id) : author.id== null;
	}
		
}
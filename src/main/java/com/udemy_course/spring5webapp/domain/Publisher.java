package com.udemy_course.spring5webapp.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Publisher {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="publisher_id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address_line1")
	private String addressLine1;
	
	private String city;
	
	private String state;
	
	private String zip;
	
	@OneToMany
	@JoinColumn(name="publisher_id")
	private Set<Book> books= new HashSet<>();
	
	public Publisher() {
		
	}
	
	public Publisher(String name, String addressLine1, String city, String state, String zip) {
		this.name = name;
		this.addressLine1 = addressLine1;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", addressLine1=" + addressLine1 + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + "]";
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
		Publisher pub = (Publisher) obj;
		return id != null?Objects.equals(id, pub.id) : pub.id== null;
	}

}

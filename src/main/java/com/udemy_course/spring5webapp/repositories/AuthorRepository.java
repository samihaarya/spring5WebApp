package com.udemy_course.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.udemy_course.spring5webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}

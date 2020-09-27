package repositories;

import org.springframework.data.repository.CrudRepository;

import com.udemy_course.spring5webapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}

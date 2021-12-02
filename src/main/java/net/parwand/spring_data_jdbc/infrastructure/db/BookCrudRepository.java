package net.parwand.spring_data_jdbc.infrastructure.db;

import net.parwand.spring_data_jdbc.domain.model.book.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookCrudRepository extends CrudRepository<Book, Long> {
    Book findBookById(Long id);
}

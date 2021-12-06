package net.parwand.spring_data_jdbc.infrastructure.db;

import net.parwand.spring_data_jdbc.infrastructure.dto.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookDAO extends CrudRepository<BookEntity, Long> {
    BookEntity findBookById(Long id);
}

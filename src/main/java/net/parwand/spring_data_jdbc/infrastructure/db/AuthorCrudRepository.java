package net.parwand.spring_data_jdbc.infrastructure.db;

import net.parwand.spring_data_jdbc.domain.model.author.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorCrudRepository extends CrudRepository<Author, Long> {
    Author findAuthorById(Long id);
}

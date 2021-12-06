package net.parwand.spring_data_jdbc.infrastructure.db;

import net.parwand.spring_data_jdbc.domain.model.author.Author;
import net.parwand.spring_data_jdbc.infrastructure.dto.AuthorEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuthorDAO extends CrudRepository<AuthorEntity, Long> {
    AuthorEntity findAuthorById(Long id);
}

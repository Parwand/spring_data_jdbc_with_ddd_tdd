package net.parwand.spring_data_jdbc.infrastructure.db;

import net.parwand.spring_data_jdbc.domain.model.author.Author;
import net.parwand.spring_data_jdbc.service.author.AuthorRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepositoryImp implements AuthorRepository {
    final
    AuthorCrudRepository authorCrudRepository;

    public AuthorRepositoryImp(AuthorCrudRepository authorCrudRepository) {
        this.authorCrudRepository = authorCrudRepository;
    }

    @Override
    public Author findAuthorById(Long id) {
        return authorCrudRepository.findAuthorById(id);
    }

    @Override
    public void save(Author author) {
        authorCrudRepository.save(author);
    }
}

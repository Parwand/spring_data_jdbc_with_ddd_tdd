package net.parwand.spring_data_jdbc.infrastructure.db;

import net.parwand.spring_data_jdbc.domain.model.author.Author;
import net.parwand.spring_data_jdbc.infrastructure.dto.AuthorEntity;
import net.parwand.spring_data_jdbc.service.author.AuthorRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepositoryImp implements AuthorRepository {
    final
    AuthorDAO authorDAO;

    public AuthorRepositoryImp(AuthorDAO authorDTO) {
        this.authorDAO = authorDTO;
    }

    @Override
    public Author findAuthorById(Long id) {
        AuthorEntity authorEntity = authorDAO.findAuthorById(id);
        return Author.create(authorEntity.getId(), authorEntity.getName());
    }

    @Override
    public void save(Author author) {
        authorDAO.save(new AuthorEntity(null, author.getName()));
    }
}

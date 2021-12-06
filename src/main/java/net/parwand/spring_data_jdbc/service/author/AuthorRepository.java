package net.parwand.spring_data_jdbc.service.author;

import net.parwand.spring_data_jdbc.domain.model.author.Author;

public interface AuthorRepository{

    Author findAuthorById(Long id);

    void save(Author author);
}

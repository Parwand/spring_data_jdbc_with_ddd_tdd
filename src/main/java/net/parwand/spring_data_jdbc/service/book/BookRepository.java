package net.parwand.spring_data_jdbc.service.book;

import net.parwand.spring_data_jdbc.domain.model.book.Book;

public interface BookRepository{
    Book findBookById(Long id);

    void save(Book book);
}

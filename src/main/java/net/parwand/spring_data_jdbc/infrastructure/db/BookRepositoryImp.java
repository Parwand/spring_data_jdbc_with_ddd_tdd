package net.parwand.spring_data_jdbc.infrastructure.db;

import net.parwand.spring_data_jdbc.domain.model.book.Book;
import net.parwand.spring_data_jdbc.service.book.BookRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImp implements BookRepository {
    private BookCrudRepository bookCrudRepository;

    public BookRepositoryImp(BookCrudRepository bookCrudRepository) {
        this.bookCrudRepository = bookCrudRepository;
    }

    @Override
    public Book findBookById(Long id) {
        return bookCrudRepository.findBookById(id);
    }

    @Override
    public void save(Book book) {
        bookCrudRepository.save(book);
    }
}

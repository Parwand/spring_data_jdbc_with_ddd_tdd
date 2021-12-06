package net.parwand.spring_data_jdbc.infrastructure.db;

import net.parwand.spring_data_jdbc.domain.model.book.Book;
import net.parwand.spring_data_jdbc.infrastructure.dto.BookEntity;
import net.parwand.spring_data_jdbc.service.book.BookRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImp implements BookRepository {
    private BookDAO bookCrudRepository;

    public BookRepositoryImp(BookDAO bookCrudRepository) {
        this.bookCrudRepository = bookCrudRepository;
    }

    @Override
    public Book findBookById(Long id) {
        BookEntity bookEntity = bookCrudRepository.findBookById(id);
        return Book.create(bookEntity.getId(), bookEntity.getTitle(), bookEntity.getIsbn(), bookEntity.getText());
    }

    @Override
    public void save(Book book) {
        bookCrudRepository.save(new BookEntity(null, book.getTitle(), book.getIsbn(), book.getText()));
    }
}

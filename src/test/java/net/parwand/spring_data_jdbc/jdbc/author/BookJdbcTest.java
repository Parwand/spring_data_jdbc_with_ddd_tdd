package net.parwand.spring_data_jdbc.jdbc.author;

import net.parwand.spring_data_jdbc.domain.model.author.Author;
import net.parwand.spring_data_jdbc.domain.model.book.Book;
import net.parwand.spring_data_jdbc.infrastructure.db.AuthorDAO;
import net.parwand.spring_data_jdbc.infrastructure.db.BookDAO;
import net.parwand.spring_data_jdbc.infrastructure.dto.AuthorEntity;
import net.parwand.spring_data_jdbc.infrastructure.dto.BookEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @Author
 * @PARWAND_ALSINO
 */
@DataJdbcTest
@ActiveProfiles("test")
public class BookJdbcTest {
    @Autowired
    private BookDAO bookRepository;
    @Autowired
    private AuthorDAO authorRepository;


    @Test
    @DisplayName("The Author can be saved in the databases")
    @Sql("classpath:db/migration/V1__initial.sql")
    void test_1(){
        //arrange
        Author author = Author.create(null, "James Gosling");
        AuthorEntity authorEntity = new AuthorEntity(null, author.getName());
        // act
        authorRepository.save(authorEntity);
        author.setId(authorEntity.getId());
        AuthorEntity authorById = authorRepository.findAuthorById(author.getId());

        // assert
        assertThat(Author.create(authorById.getId(), authorById.getName())).isEqualTo(author);


    }

    @Test
    @DisplayName("The book with Author can be saved in the databases")
    @Sql("classpath:db/migration/V1__initial.sql")
    void test_2(){
        //arrange
        Author author = Author.create(null, "James Gosling");
        AuthorEntity authorEntity = new AuthorEntity(null, author.getName());
        authorRepository.save(authorEntity);
        author.setId(authorEntity.getId());
        Book book = Book.create(null, "The Java Programming Language", "9780201634556", "..JAVA..");
        BookEntity bookEntity = new BookEntity(null, book.getTitle(), book.getIsbn(), book.getText());
        bookRepository.save(bookEntity);
        book.setId(bookEntity.getId());

        // act
        BookEntity bookById = bookRepository.findBookById(bookEntity.getId());

        // assert
        assertThat(Book.create(bookById.getId(), bookById.getTitle(), bookById.getIsbn(), bookById.getText())).isEqualTo(book);
    }

    @Test
    @DisplayName("The book with Author can be saved in the databases")
    @Sql("classpath:db/migration/V1__initial.sql")
    void test_3(){
        //arrange
        Author author = Author.create(null, "James Gosling");
        AuthorEntity authorEntity = new AuthorEntity(null, author.getName());
        authorRepository.save(authorEntity);
        author.setId(authorEntity.getId());
        Book book = Book.create(null, "The Java Programming Language", "9780201634556", "..JAVA..");
        BookEntity bookEntity = new BookEntity(null, book.getTitle(), book.getIsbn(), book.getText());
        book.addAuthors(author);
        bookRepository.save(bookEntity);
        book.setId(bookEntity.getId());

        // act
        BookEntity bookById = bookRepository.findBookById(bookEntity.getId());

        // assert
        assertThat(Book.create(bookById.getId(), bookById.getTitle(), bookById.getIsbn(), bookById.getText())).isEqualTo(book);
    }



    @Test
    @DisplayName("One Book with tow Authors can be saved in Database")
    @Sql("classpath:db/migration/V1__initial.sql")
    void test_4(){
        Author author1 = Author.create(null, "Arthur Samuel");
        Author author2 = Author.create(null, "Philip C Jackson");

        AuthorEntity authorEntity1 = new AuthorEntity(null, author1.getName());
        AuthorEntity authorEntity2 = new AuthorEntity(null, author2.getName());

        authorRepository.save(authorEntity1);
        authorRepository.save(authorEntity2);
        author1.setId(authorEntity1.getId());
        author2.setId(authorEntity2.getId());

        Book book = Book.create(null, "Artificial Intelligence", "9780486248646", "..ML..");
        book.addAuthors(author1);
        book.addAuthors(author2);

        BookEntity bookEntity = new BookEntity(null, book.getTitle(), book.getIsbn(), book.getText());
        bookEntity.addAuthors(authorEntity1);
        bookEntity.addAuthors(authorEntity2);


        bookRepository.save(bookEntity);
        book.setId(bookEntity.getId());
        BookEntity bookById = bookRepository.findBookById(bookEntity.getId());
        assertThat(Book.create(bookById.getId(), bookById.getTitle(), bookById.getIsbn(), bookById.getText())).isEqualTo(book);

    }

    @Test
    @DisplayName("One Author with tow Books can be saved in Database")
    @Sql("classpath:db/migration/V1__initial.sql")
    void test_5(){
        Author author = Author.create(null, "Eric Evans");
        AuthorEntity authorEntity = new AuthorEntity(null, author.getName());
        authorRepository.save(authorEntity);

        Book book1 = Book.create(null, "Domain-Driven Design", "9780321125217", "..DDD..");
        Book book2 = Book.create(null, "Implementing Domain-Driven Design", "9780321834577", "..DDDImpl..");
        book1.addAuthors(author);
        book2.addAuthors(author);

        BookEntity bookEntity1 = new BookEntity(null, book1.getTitle(), book1.getIsbn(), book1.getText());
        BookEntity bookEntity2 = new BookEntity(null, book1.getTitle(), book1.getIsbn(), book2.getText());
        bookEntity1.addAuthors(authorEntity);
        bookEntity2.addAuthors(authorEntity);



        bookRepository.save(bookEntity1);
        bookRepository.save(bookEntity2);
        book1.setId(bookEntity1.getId());
        book2.setId(bookEntity1.getId());

        BookEntity book1ById = bookRepository.findBookById(book1.getId());
        BookEntity book2ById = bookRepository.findBookById(book2.getId());
        assertThat(Book.create(book1ById.getId(), book1ById.getTitle(), book1ById.getIsbn(), book1ById.getText())).isEqualTo(book1);
        assertThat(Book.create(book2ById.getId(), book2ById.getTitle(), book2ById.getIsbn(), book2ById.getText())).isEqualTo(book2);

    }
}

package net.parwand.spring_data_jdbc.jdbc.author;

import net.parwand.spring_data_jdbc.domain.model.author.Author;
import net.parwand.spring_data_jdbc.domain.model.book.Book;
import net.parwand.spring_data_jdbc.infrastructure.db.AuthorCrudRepository;
import net.parwand.spring_data_jdbc.infrastructure.db.AuthorRepositoryImp;
import net.parwand.spring_data_jdbc.infrastructure.db.BookCrudRepository;
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
    private BookCrudRepository bookRepository;
    @Autowired
    private AuthorCrudRepository authorRepository;


    @Test
    @DisplayName("The Author can be saved in the databases")
    @Sql("classpath:db/migration/V1__initial.sql")
    void test_1(){
        //arrange
        Author author = Author.create("James Gosling");

        // act
        authorRepository.save(author);
        Author authorById = authorRepository.findAuthorById(author.getId());

        // assert
        assertThat(authorById).isEqualTo(author);


    }

    @Test
    @DisplayName("The book with Author can be saved in the databases")
    @Sql("classpath:db/migration/V1__initial.sql")
    void test_2(){
        //arrange
        Author author = Author.create("James Gosling");
        authorRepository.save(author);
        Book book = Book.create("The Java Programming Language", "9780201634556", "..JAVA..");
        bookRepository.save(book);

        // act
        Book bookById = bookRepository.findBookById(book.getId());

        // assert
        assertThat(bookById).isEqualTo(book);
    }

    @Test
    @DisplayName("The book with Author can be saved in the databases")
    @Sql("classpath:db/migration/V1__initial.sql")
    void test_22(){
        //arrange
        Author author = Author.create("James Gosling");
        authorRepository.save(author);
        Book book = Book.create("The Java Programming Language", "9780201634556", "..JAVA..");
        book.addAuthors(author);
        bookRepository.save(book);

        // act
        Book bookById = bookRepository.findBookById(book.getId());

        // assert
        assertThat(bookById).isEqualTo(book);
    }



    @Test
    @DisplayName("One Book with tow Authors can be saved in Database")
    @Sql("classpath:db/migration/V1__initial.sql")
    void test_3(){
        Author author1 = Author.create("Arthur Samuel");
        Author author2 = Author.create("Philip C Jackson");

        authorRepository.save(author1);
        authorRepository.save(author2);

        Book book = Book.create("Artificial Intelligence", "9780486248646", "..ML..");
        book.addAuthors(author1);
        book.addAuthors(author2);
        bookRepository.save(book);
        Book bookById = bookRepository.findBookById(book.getId());
        assertThat(bookById).isEqualTo(book);

    }

    @Test
    @DisplayName("One Author with tow Books can be saved in Database")
    @Sql("classpath:db/migration/V1__initial.sql")
    void test_4(){
        Author author = Author.create("Eric Evans");

        authorRepository.save(author);

        Book book1 = Book.create("Domain-Driven Design", "9780321125217", "..DDD..");
        Book book2 = Book.create("Implementing Domain-Driven Design", "9780321834577", "..DDDImpl..");
        book1.addAuthors(author);
        book2.addAuthors(author);
        bookRepository.save(book1);
        bookRepository.save(book2);
        Book book1ById = bookRepository.findBookById(book1.getId());
        Book book2ById = bookRepository.findBookById(book2.getId());
        assertThat(book1ById).isEqualTo(book1);
        assertThat(book2ById).isEqualTo(book2);

    }
}

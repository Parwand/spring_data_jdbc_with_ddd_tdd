package net.parwand.spring_data_jdbc.domain.model.book;

import net.parwand.spring_data_jdbc.domain.model.author.Author;
import net.parwand.spring_data_jdbc.domain.model.author.AuthorRef;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Author PAR ALS
 * //TODO @MANY_TO_MANY (AUTHOR -n-----m- BOOK)
 */
@Table("BOOK")
public class Book {
    @Id
    private Long id;

    private String title;
    private String isbn;
    private String text;


    private Set<AuthorRef> authors = new HashSet<>();

    private Book(Long id, String title, String isbn, String text) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.text = text;
    }

    public static Book create(String title, String isbn, String text) {
        return  new Book(null, title, isbn, text);
    }

    public void addAuthors(Author author) {
        this.authors.add(new AuthorRef(author.getId()));
    }

    public Set<AuthorRef> getAuthors() {
        return authors;
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

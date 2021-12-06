package net.parwand.spring_data_jdbc.domain.model.book;

import net.parwand.spring_data_jdbc.domain.model.author.Author;
import net.parwand.spring_data_jdbc.infrastructure.dto.AuthorRefEntity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Author PAR ALS
 * //TODO @MANY_TO_MANY (AUTHOR -n-----m- BOOK)
 */
public class Book {
    private Long id;

    private String title;
    private String isbn;
    private String text;


    private Set<AuthorRefEntity> authors = new HashSet<>();

    private Book(Long id, String title, String isbn, String text) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.text = text;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAuthors(Set<AuthorRefEntity> authors) {
        this.authors = authors;
    }

    public static Book create(Long id, String title, String isbn, String text) {
        return  new Book(id, title, isbn, text);
    }

    public void addAuthors(Author author) {
        this.authors.add(new AuthorRefEntity(author.getId()));
    }

    public Set<AuthorRefEntity> getAuthors() {
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

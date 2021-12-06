package net.parwand.spring_data_jdbc.infrastructure.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

@Table("BOOK")
public class BookEntity {
    @Id
    private Long id;

    private String title;
    private String isbn;
    private String text;
    private Set<AuthorRefEntity> authors = new HashSet<>();

    public BookEntity(Long id, String title, String isbn, String text) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.text = text;
    }
    public void addAuthors(AuthorEntity author) {
        this.authors.add(new AuthorRefEntity(author.getId()));
    }


    public Long getId() {
        return id;
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
}

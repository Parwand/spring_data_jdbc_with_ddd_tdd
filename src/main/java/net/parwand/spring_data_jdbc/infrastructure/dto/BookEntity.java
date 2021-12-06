package net.parwand.spring_data_jdbc.infrastructure.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("BOOK")
public class BookEntity {
    @Id
    private Long id;

    private String title;
    private String isbn;
    private String text;

    public BookEntity(Long id, String title, String isbn, String text) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.text = text;
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

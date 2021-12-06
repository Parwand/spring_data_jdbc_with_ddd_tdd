package net.parwand.spring_data_jdbc.domain.model.author;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;
/**
 * @Author PAR ALS
 * //TODO @MANY_TO_MANY (AUTHOR -n-----m- BOOK) , we need here three tables (author, book, & author_book to reference)
 */
public class Author {

    private Long id;
    private String name;

    private Author(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Author create(String name){
        return new Author(null, name);
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

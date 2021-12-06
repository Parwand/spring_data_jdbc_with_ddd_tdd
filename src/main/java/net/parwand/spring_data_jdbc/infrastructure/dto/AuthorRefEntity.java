package net.parwand.spring_data_jdbc.infrastructure.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("AUTHOR_BOOK")
public class AuthorRefEntity {

    /**
     * @Author PAL
     */
    @Id
    private Long author;
    public AuthorRefEntity(Long author) {
        this.author = author;
    }
}

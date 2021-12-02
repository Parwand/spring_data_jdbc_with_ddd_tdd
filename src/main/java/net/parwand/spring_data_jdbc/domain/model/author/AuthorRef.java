package net.parwand.spring_data_jdbc.domain.model.author;

import org.springframework.data.relational.core.mapping.Table;

@Table("AUTHOR_BOOK")
public class AuthorRef {

    /**
     * @Author PAAL100
     *
     */
    private Long author;
    public AuthorRef(Long author) {
        this.author = author;
    }
}

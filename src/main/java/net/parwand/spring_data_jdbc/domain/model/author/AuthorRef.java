package net.parwand.spring_data_jdbc.domain.model.author;

import org.springframework.data.relational.core.mapping.Table;

public class AuthorRef {

    /**
     * @Author PAL
     */
    private Long author;
    public AuthorRef(Long author) {
        this.author = author;
    }
}

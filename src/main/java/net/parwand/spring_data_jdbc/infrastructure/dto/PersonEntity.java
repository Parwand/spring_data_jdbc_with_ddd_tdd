package net.parwand.spring_data_jdbc.infrastructure.dto;

import net.parwand.spring_data_jdbc.domain.model.person.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("PERSON")
public class PersonEntity {

    @Id
    private Long id;
    private String name;
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

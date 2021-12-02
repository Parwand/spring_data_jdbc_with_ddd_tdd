package net.parwand.spring_data_jdbc.domain.model.person;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

/**
 * @Author PAR ALS
 * //TODO @ONE_TO_ONE (PERSON -1-----1- ADDRESS)
 * // Person must have no address ==> save personID in Address table
 */
@Table("PERSON")
public class Person {
    @Id
    private Long id;
    private String name;
    private Address address;

    private Person(Long id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public static Person create(String name, Address address){
        return new Person(null, name, address);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    public Long geId() {
        return this.id;
    }
}
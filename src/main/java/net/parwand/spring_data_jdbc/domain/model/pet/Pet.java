package net.parwand.spring_data_jdbc.domain.model.pet;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

/**
 * @TODO NO_RELATION
 */
public class Pet {

    private Long id;
    private String name;
    private LocalDate birthDate;

    public Pet(Long id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public static Pet create(String name, LocalDate birthDate){
        return new Pet(null, name, birthDate);
    }

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}

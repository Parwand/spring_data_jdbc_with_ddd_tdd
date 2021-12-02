package net.parwand.spring_data_jdbc.jdbc.pet;

import net.parwand.spring_data_jdbc.domain.model.pet.Pet;
import net.parwand.spring_data_jdbc.infrastructure.db.PetRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;

@SpringBootTest
@ActiveProfiles("test")
class PetJdbcTest {

    @Autowired
    PetRepositoryImpl PetRepositoryImpl;

    @Test
    @DisplayName("PET can be saved in the database")
    @Sql({"classpath:db/migration/V1__initial.sql"})
    void test_1() {

        Pet pet = Pet.create("Cat", LocalDate.of(2015, 12, 04));
        PetRepositoryImpl.save(pet);
    }
}

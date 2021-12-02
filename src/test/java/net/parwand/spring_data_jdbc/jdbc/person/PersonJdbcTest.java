package net.parwand.spring_data_jdbc.jdbc.person;

import net.parwand.spring_data_jdbc.domain.model.person.Address;
import net.parwand.spring_data_jdbc.domain.model.person.Person;
import net.parwand.spring_data_jdbc.infrastructure.db.PersonRepositoryImp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class PersonJdbcTest {
    @Autowired
    private PersonRepositoryImp personRepositoryImp;

    @Test
    @DisplayName("Person and Address can be saved in database")
    @Sql("classpath:db/migration/V1__initial.sql")
    void test_1(){
        Address address = new Address("Uni 1", 40445, "DU");
        Person person = Person.create("Lio", address);
        personRepositoryImp.save(person);
        Person lio = personRepositoryImp.findPersonById(person.geId());
        assertThat(lio).isEqualTo(person);
    }

    @Test
    @DisplayName("Person can be saved without Address in database")
    @Sql("classpath:db/migration/V1__initial.sql")
    void test_2(){
        Person person = Person.create("Lucas", null);
        personRepositoryImp.save(person);
        Person lucas = personRepositoryImp.findPersonById(person.geId());
        assertThat(lucas).isEqualTo(person);
    }

    @Test
    @DisplayName("Person and Address can be saved in database")
    @Sql("classpath:db/migration/V1__initial.sql")
    void test_3(){
        Address address = new Address("King Street 5", 5423, "London");
        Person person = Person.create("Max", address);
        personRepositoryImp.save(person);
        Person max = personRepositoryImp.findPersonById(person.geId());
        assertThat(max).isEqualTo(person);
    }
}
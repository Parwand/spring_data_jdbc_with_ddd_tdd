package net.parwand.spring_data_jdbc.infrastructure.db;

import net.parwand.spring_data_jdbc.domain.model.person.Person;
import net.parwand.spring_data_jdbc.service.person.PersonRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryImp implements PersonRepository {

    PersonCrudRepository personCrudRepository;

    public PersonRepositoryImp(PersonCrudRepository personCrudRepository) {
        this.personCrudRepository = personCrudRepository;
    }

    @Override
    public Person findPersonById(Long id) {
        return personCrudRepository.findPersonById(id);
    }

    @Override
    public void save(Person person) {
        personCrudRepository.save(person);
    }
}

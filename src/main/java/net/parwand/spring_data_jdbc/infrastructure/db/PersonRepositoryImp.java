package net.parwand.spring_data_jdbc.infrastructure.db;

import net.parwand.spring_data_jdbc.domain.model.person.Person;
import net.parwand.spring_data_jdbc.infrastructure.dto.PersonEntity;
import net.parwand.spring_data_jdbc.service.person.PersonRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryImp implements PersonRepository {

    PersonDAO personCrudRepository;

    public PersonRepositoryImp(PersonDAO personCrudRepository) {
        this.personCrudRepository = personCrudRepository;
    }

    @Override
    public Person findPersonById(Long id) {
        PersonEntity person = personCrudRepository.findPersonById(id);
        return Person.create(person.getId(), person.getName(), person.getAddress());
    }

    @Override
    public void save(Person person) {
        PersonEntity personEntity = new PersonEntity(null, person.getName(), person.getAddress());
        personCrudRepository.save(personEntity);
        person.setId(personEntity.getId());
    }
}

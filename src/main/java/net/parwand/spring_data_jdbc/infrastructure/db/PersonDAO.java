package net.parwand.spring_data_jdbc.infrastructure.db;

import net.parwand.spring_data_jdbc.domain.model.person.Person;
import net.parwand.spring_data_jdbc.infrastructure.dto.PersonEntity;
import org.springframework.data.repository.CrudRepository;

public interface PersonDAO extends CrudRepository<PersonEntity, Long> {
    PersonEntity findPersonById(Long name);
}

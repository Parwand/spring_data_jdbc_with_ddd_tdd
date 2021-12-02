package net.parwand.spring_data_jdbc.service.person;


import net.parwand.spring_data_jdbc.domain.model.person.Person;

public interface PersonRepository{

    Person findPersonById(Long name);

    void save(Person person);
}

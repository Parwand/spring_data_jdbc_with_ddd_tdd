package net.parwand.spring_data_jdbc.infrastructure.db;

import net.parwand.spring_data_jdbc.domain.model.pet.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface PetCrudRepository extends CrudRepository<Pet, Long> {
}

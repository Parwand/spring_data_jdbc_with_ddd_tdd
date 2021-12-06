package net.parwand.spring_data_jdbc.infrastructure.db;

import net.parwand.spring_data_jdbc.domain.model.pet.Pet;
import net.parwand.spring_data_jdbc.infrastructure.dto.PetEntity;
import org.springframework.data.repository.CrudRepository;

public interface PetDAO extends CrudRepository<PetEntity, Long> {
}

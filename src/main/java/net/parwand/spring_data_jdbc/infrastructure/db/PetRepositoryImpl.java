package net.parwand.spring_data_jdbc.infrastructure.db;

import net.parwand.spring_data_jdbc.domain.model.pet.Pet;
import net.parwand.spring_data_jdbc.service.pet.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PetRepositoryImpl implements PetRepository {

    @Autowired
    PetCrudRepository petCrudRepository;

    @Override
    public void save(Pet pet) {
        petCrudRepository.save(pet);
    }
}
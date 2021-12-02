package net.parwand.spring_data_jdbc.service.pet;

import net.parwand.spring_data_jdbc.domain.model.pet.Pet;

public interface PetRepository{

    void save(Pet pet);
}

package com.udacity.dogrestapi.repository;

import com.udacity.dogrestapi.model.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}

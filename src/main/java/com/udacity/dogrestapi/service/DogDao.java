package com.udacity.dogrestapi.service;

import com.udacity.dogrestapi.model.Dog;

import java.util.List;

public interface DogDao {

    List<Dog> retrieveDogs();
    Dog retrieveDogById(Long id);
    List<String> retrieveDogBreed();
    String retrieveDogBreedById(Long id);
    List<String> retrieveDogNames();

    void insertDog(Dog dog);


}

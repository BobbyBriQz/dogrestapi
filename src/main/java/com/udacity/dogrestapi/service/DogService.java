package com.udacity.dogrestapi.service;


import com.udacity.dogrestapi.model.Dog;
import com.udacity.dogrestapi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DogService implements DogDao {

    @Autowired
    DogRepository dogRepository;

    @Override
    public List<Dog> retrieveDogs() {

        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public Dog retrieveDogById(Long id) {

        Optional<Dog> maybeDog = dogRepository.findById(id);

        return maybeDog.orElse(null);


    }

    @Override
    public List<String> retrieveDogBreed() {
        List<Dog> dogs = retrieveDogs();
        List<String> breed = new ArrayList<>();

        for(Dog dog : dogs){
            breed.add(dog.getBreed());
        }

        return breed;
    }

    @Override
    public String retrieveDogBreedById(Long id) {

        Dog dog = retrieveDogById(id);
        if (dog != null) return dog.getBreed();
        return null;
    }

    @Override
    public List<String> retrieveDogNames() {

        List<Dog> dogs = retrieveDogs();
        List<String> names = new ArrayList<>();

        for(Dog dog : dogs){
            names.add(dog.getName());
        }

        return names;
    }

    @Override
    public void insertDog(Dog dog) {

        dogRepository.save(dog);
    }
}

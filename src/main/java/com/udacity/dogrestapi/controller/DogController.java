package com.udacity.dogrestapi.controller;


import com.udacity.dogrestapi.model.Dog;
import com.udacity.dogrestapi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DogController {

    @Autowired
    private DogService dogService;

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> retrieveDogs() {

        List<Dog> dogs = dogService.retrieveDogs();

        return new ResponseEntity<>(dogs, HttpStatus.OK);
    }


    @GetMapping("/dogs/{id}")
    public ResponseEntity<Dog> retrieveDogById(@PathVariable Long id) {

        Dog dogWithId = dogService.retrieveDogById(id);

        if (dogWithId != null) return new ResponseEntity<>(dogWithId, HttpStatus.OK);

        return new ResponseEntity<>(dogWithId, HttpStatus.NOT_FOUND);
    }


    @GetMapping("/dogs/breed")
    public ResponseEntity<List<String>> retrieveDogBreed() {
        List<String> list = dogService.retrieveDogBreed();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/dogs/{id}/breed")
    public ResponseEntity<String> retrieveDogBreedById(@PathVariable Long id) {
        String breed = dogService.retrieveDogBreedById(id);

        if (breed != null) return new ResponseEntity<>(breed, HttpStatus.OK);

        return new ResponseEntity<>(breed, HttpStatus.NOT_FOUND);

    }

    @GetMapping("/dogs/names")
    public ResponseEntity<List<String>> retrieveDogNames() {
        List<String> list = dogService.retrieveDogNames();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/dogs")
    public ResponseEntity<Dog> insertDog(@Valid @RequestBody Dog dog){
        Dog savedDog = dogService.insertDog(dog);
        return new ResponseEntity<>(savedDog, HttpStatus.OK);
    }

    @DeleteMapping("/dogs/{id}")
    public void deleteDogById(@PathVariable(value = "id") Long id){
        dogService.deleteDogById(id);
    }

    @DeleteMapping("/dogs")
    public void deleteAllDogs(){
        dogService.deleteAllDogs();
    }
}

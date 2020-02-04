package com.udacity.dogrestapi.controller;


import com.udacity.dogrestapi.model.Dog;
import com.udacity.dogrestapi.service.DogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DogController {

    @Autowired
    DogDao dogDao;

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> retrieveDogs() {

        List<Dog> dogs = dogDao.retrieveDogs();

        return new ResponseEntity<List<Dog>>(dogs, HttpStatus.OK);
    }


    @GetMapping("/dogs/{id}")
    public ResponseEntity<Dog> retrieveDogById(@PathVariable Long id) {

        Dog dogWithId = dogDao.retrieveDogById(id);

        if (dogWithId != null) return new ResponseEntity<Dog>(dogWithId, HttpStatus.OK);

        return new ResponseEntity<Dog>(dogWithId, HttpStatus.NOT_FOUND);
    }


    @GetMapping("/dogs/breed")
    public ResponseEntity<List<String>> retrieveDogBreed() {
        List<String> list = dogDao.retrieveDogBreed();

        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @GetMapping("/dogs/{id}/breed")
    public ResponseEntity<String> retrieveDogBreedById(@PathVariable Long id) {
        String breed = dogDao.retrieveDogBreedById(id);

        if (breed != null) return new ResponseEntity<String>(breed, HttpStatus.OK);

        return new ResponseEntity<String>(breed, HttpStatus.NOT_FOUND);

    }

    @GetMapping("/dogs/names")
    public ResponseEntity<List<String>> retrieveDogNames() {
        List<String> list = dogDao.retrieveDogNames();

        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }
}

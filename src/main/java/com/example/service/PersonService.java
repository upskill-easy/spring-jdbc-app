package com.example.service;

import java.util.List;

import com.example.model.Person;

public interface PersonService {

    int create(Person person);

    List<Person> findlAll();
}

package com.example.dao;

import java.util.List;

import com.example.model.Person;

public interface PersonDao {

    int create(Person person);

    List<Person> findlAll();
}

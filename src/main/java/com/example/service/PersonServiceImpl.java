package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dao.PersonDao;
import com.example.model.Person;

// import lombok.RequiredArgsConstructor;

@Service
// @RequiredArgsConstructor // Option 3 for auto wiring
public class PersonServiceImpl implements PersonService {

    // @Autowired -> Option 1 for auto wiring
    private final PersonDao personDao;

    // Option 2 for auto wiring
    public PersonServiceImpl(PersonDao personDao){
        this.personDao = personDao;
    }

    @Override
    public int create(Person person) {
        return personDao.create(person);
    }

    @Override
    public List<Person> findlAll() {
        return personDao.findlAll();
    }

}

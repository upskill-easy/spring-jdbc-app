package com.example.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao {

    private final String INSERT_QUERY = "INSERT INTO PEOPLE VALUES (?, ?, ?, ?)";
    private final String SELECT_QUERY = "SELECT ID, FIRST_NAME, LAST_NAME, AGE FROM PEOPLE";

    private JdbcTemplate jdbcTemplate;

    public PersonDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int create(Person person) {
        return jdbcTemplate.update(
                INSERT_QUERY,
                person.getId(), person.getFirstName(), person.getLastName(), person.getAge());
    }

    @Override
    public List<Person> findlAll() {
        // return jdbcTemplate.query(SELECT_QUERY,
        // (rs, num) -> new Person(
        // rs.getInt(1),
        // rs.getString(2),
        // rs.getString(3),
        // rs.getInt(1)));
        return jdbcTemplate.query(SELECT_QUERY, new PersonRowMapper());
    }

}

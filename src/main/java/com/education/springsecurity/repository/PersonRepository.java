package com.education.springsecurity.repository;

import com.education.springsecurity.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    public Optional<Person> findByEmail(String email);

    public void deletePersonById(long id);
}

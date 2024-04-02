package com.education.springsecurity.service;

import com.education.springsecurity.dto.PersonDto;

public interface PersonService {

    public void create(PersonDto personDto);

    public PersonDto findPerson(long id);

    public void updatePerson(PersonDto personDto);

    public void deletePerson(long id);
}

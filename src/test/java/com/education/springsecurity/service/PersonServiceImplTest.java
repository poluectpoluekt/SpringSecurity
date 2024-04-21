package com.education.springsecurity.service;

import com.education.springsecurity.dto.PersonDto;
import com.education.springsecurity.exception.UserNoFoundException;
import com.education.springsecurity.mapper.PersonMapper;
import com.education.springsecurity.model.Person;
import com.education.springsecurity.repository.PersonRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @Mock
    PersonMapper personMapper;

    @Mock
    PersonRepository personRepository;

    @InjectMocks
    PersonServiceImpl personService;

    @Test
    void createPersonTest(){

    }


    @Test
    void findPerson_returnPeronDto(){

        long idPerson = 2L;
        Person person = new Person();
        person.setId(idPerson);
        person.setEmail("email");
        person.setPassword("password");
        person.setEvents(null);

        PersonDto personDtoExpect = new PersonDto(2, "email", "password", null );

        Mockito.when(personRepository.findById(idPerson)).thenReturn(Optional.of(person));
        Mockito.when(personMapper.toPersonDto(person)).thenReturn(personDtoExpect);

        PersonDto personDto = personService.findPerson(2);

        assertEquals(personDtoExpect, personDto);

    }


    @Test
    @DisplayName("Возврат исключения, если person не найден в БД")
    void findPerson_returnExceptionNotFoundUser(){

        long idPerson = 2L;

        Mockito.when(personRepository.findById(idPerson)).thenReturn(Optional.empty());

        assertThrows(UserNoFoundException.class, () -> personService.findPerson(2));

    }

}
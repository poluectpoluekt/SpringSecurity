package com.education.springsecurity.service;

import com.education.springsecurity.dto.PersonDto;
import com.education.springsecurity.exception.UserAlreadyRegistered;
import com.education.springsecurity.exception.UserNoFoundException;
import com.education.springsecurity.mapper.PersonMapper;
import com.education.springsecurity.model.Person;
import com.education.springsecurity.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;


@Log4j
@AllArgsConstructor
@Service
public class PersonServiceImpl implements PersonService, UserDetailsService {

    private final PersonRepository personRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final PersonMapper personMapper;

    @Transactional
    @Override
    public void create(PersonDto personDto) {

        if(personRepository.findByEmail(personDto.getEmail()).isEmpty()){
            log.error("Trying to save a user that already exists.");
            throw new UserAlreadyRegistered("This user already exists.");
        }else {
            Person person = personMapper.toPerson(personDto);
            person.setPassword(bCryptPasswordEncoder.encode(personDto.getPassword()));
            person.setAccountNonExpired(true);
            person.setAccountNonLocked(true);
            person.setCredentialsNonExpired(true);
            person.setEnabled(true);
            personRepository.save(person);
        }

    }

    @Override
    public PersonDto findPerson(long id) {

        return personMapper.toPersonDto(personRepository.findById(id).orElseThrow(()-> new UserNoFoundException("User bot found.")));
    }

    @Override
    public void updatePerson(PersonDto personDto) {

            Person person = personRepository.findById(personDto.getId()).orElseThrow(()-> new UserNoFoundException("User bot found."));
            Person personNew = personMapper.toPerson(personDto);

        if(!personNew.equals(person)){
            //TODO пока не предумал, что изменять. Для email и pass думаю, что лучше отдельные методы сделать
        }
        System.out.println("Persona has been updated");  // заглушка
    }

    @Override
    public void deletePerson(long id) {

        personRepository.deletePersonById(id);

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return personRepository.findByEmail(email).orElseThrow(()-> new UserNoFoundException("User not found: " + email));
    }
}

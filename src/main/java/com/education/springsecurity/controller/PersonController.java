package com.education.springsecurity.controller;

import com.education.springsecurity.dto.PersonDto;
import com.education.springsecurity.service.PersonServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class PersonController {

    private final PersonServiceImpl personService;


    @PatchMapping ("/edit")
    public void editPerson(){

    }

    @GetMapping("/find")
    public PersonDto findPerson(){

        //TODO
        return null;
    }

    @PostMapping("/signup")
    public void registration(@Valid @RequestBody PersonDto personDto){

        personService.create(personDto);
    }

    @DeleteMapping("delete")
    public void deletePerson(){

    }



}


package com.education.springsecurity.controller;

import com.education.springsecurity.dto.PersonDto;
import com.education.springsecurity.service.PersonServiceImpl;
import lombok.AllArgsConstructor;
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
        return null;
    }

    @PostMapping("/registration")
    public void registration(@RequestBody PersonDto personDto){

    }

    @DeleteMapping("delete")
    public void deletePerson(){

    }

}


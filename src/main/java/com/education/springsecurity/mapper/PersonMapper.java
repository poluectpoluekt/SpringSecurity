package com.education.springsecurity.mapper;

import com.education.springsecurity.dto.PersonDto;
import com.education.springsecurity.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    public Person toPerson(PersonDto personDto);

    public PersonDto toPersonDto(Person person);
}

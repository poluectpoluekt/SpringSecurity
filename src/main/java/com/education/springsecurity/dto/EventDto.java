package com.education.springsecurity.dto;

import com.education.springsecurity.model.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventDto {

    private long id;
    private String name;
    private LocalDateTime date;
    private Person owner;
    private String description;
}

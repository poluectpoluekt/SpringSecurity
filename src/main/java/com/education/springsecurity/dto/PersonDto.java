package com.education.springsecurity.dto;


import com.education.springsecurity.model.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonDto {

    private long id;
    private String email;
    private String password;
    private List<Event> events;

}

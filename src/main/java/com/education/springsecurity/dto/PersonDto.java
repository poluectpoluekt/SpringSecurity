package com.education.springsecurity.dto;


import com.education.springsecurity.model.Event;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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

    @NotEmpty(message = "Email should not be empty.")
    @Size(min = 6, max = 50, message = "Email should between 6 and 50 characters.")
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message = "Password should not be empty.")
    @Min(value = 6, message = "Password must be longer than 6 characters.")
    private String password;
    private List<Event> events;

}

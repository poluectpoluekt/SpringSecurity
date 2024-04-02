package com.education.springsecurity.exception.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Класс, которым будем отвечать пользователю
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonErrorResponse {

    private String message;
    private Long timestamp;

}

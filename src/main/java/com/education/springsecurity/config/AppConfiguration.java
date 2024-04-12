package com.education.springsecurity.config;

import com.education.springsecurity.dto.PersonDto;
import com.education.springsecurity.mapper.PersonMapper;
import com.education.springsecurity.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}

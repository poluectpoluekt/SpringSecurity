package com.education.springsecurity.service;


import com.education.springsecurity.mapper.EventMapper;
import com.education.springsecurity.model.Event;
import com.education.springsecurity.repository.EventRepository;
import com.education.springsecurity.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    private final EventMapper eventMapper;


    @Override
    public void create() {

    }

    @Override
    public Event read() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}

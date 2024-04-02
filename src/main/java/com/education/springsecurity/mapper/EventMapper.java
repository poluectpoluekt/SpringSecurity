package com.education.springsecurity.mapper;

import com.education.springsecurity.dto.EventDto;
import com.education.springsecurity.model.Event;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EventMapper {

    //EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    public Event toEvent(EventDto eventDto);

    public EventDto toEventDto(Event event);

}

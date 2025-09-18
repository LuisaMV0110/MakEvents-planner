package com.eventplanner.spring.makevents.event_planner.services;

import com.eventplanner.spring.makevents.event_planner.dtos.EventDTO;
import com.eventplanner.spring.makevents.event_planner.models.Event;


public interface EventService extends GenericService<Event, EventDTO>{
    void createEvent(Event event);

    Event findById (long id);

    void updateEvent(Event event, long id);

    void deleteEvent(long id);
    
}

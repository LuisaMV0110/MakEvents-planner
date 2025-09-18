package com.eventplanner.spring.makevents.event_planner.services.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventplanner.spring.makevents.event_planner.dtos.EventDTO;
import com.eventplanner.spring.makevents.event_planner.models.Event;
import com.eventplanner.spring.makevents.event_planner.repositories.EventRepository;
import com.eventplanner.spring.makevents.event_planner.services.EventService;


@Service
public class EventServiceImplement implements EventService{

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<EventDTO> findAll(){
        return eventRepository.findAll().stream().map(EventDTO::new).collect(Collectors.toList());
    }

    @Override
    public void createEvent(Event event) {
       event.setTitle(event.getTitle());
       event.setDescription(event.getDescription());
       event.setImg(event.getImg());
       event.setDate(event.getDate());
       event.setLocation(event.getLocation());
       eventRepository.save(event);
    }

    @Override
    public Event findById(long id) {return eventRepository.findById(id);}

    @Override
    public void updateEvent(Event event, long id) {

    Event eventU = eventRepository.findById(id);

     eventU.setTitle(event.getTitle());
     eventU.setDescription(event.getDescription());
     eventU.setImg(event.getImg());
     eventU.setDate(event.getDate());
     eventU.setLocation(event.getLocation());
        
        
        eventRepository.save(eventU);
    }

    @Override
    public void deleteEvent(long id) {

        Event event = eventRepository.findById(id);

        eventRepository.delete(event);
    }
}

package com.eventplanner.spring.makevents.event_planner.controllers;

import java.util.List;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventplanner.spring.makevents.event_planner.dtos.EventDTO;
import com.eventplanner.spring.makevents.event_planner.models.Event;
import com.eventplanner.spring.makevents.event_planner.services.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/event")
public class EventController{

    @Autowired
    private EventService eventService;

    @GetMapping("/all")
    public List<EventDTO> getAll() {
        return eventService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEvent(@RequestBody Event event) {

        if(event.getTitle().isBlank()){
             return ResponseEntity.badRequest().body("The title of the event is missing");
        }
        if(event.getDescription().isBlank()){
             return ResponseEntity.badRequest().body("The description of the event is missing");
        }
        if(event.getImg().isBlank()){
             return ResponseEntity.badRequest().body("The image of the event is missing");
        }
        if(event.getDate() == null){
             return ResponseEntity.badRequest().body("The date of the event is missing ");
        }
        if(event.getLocation().isBlank()){
             return ResponseEntity.badRequest().body("The location of the event is missing");
        }
        
        eventService.createEvent(event);
        return ResponseEntity.ok("Event created successfully");
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateEvent(@RequestBody Event event, @PathVariable long id) {

     Event event2 = eventService.findById(id);
     
        if (event2 == null) {
            return new ResponseEntity<>("Event not exist with id: " + id, HttpStatus.NOT_FOUND);
        }
        eventService.updateEvent(event, id);

        return new ResponseEntity<>("The event was updated successfully.", HttpStatus.OK);
    }

     @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteEvent(@PathVariable long id) {

     Event event = eventService.findById(id);
     
        if (event == null) {
            return new ResponseEntity<>("Event not exist with id: " + id, HttpStatus.NOT_FOUND);
        }
        eventService.deleteEvent(id);

        return new ResponseEntity<>("The event was deleted successfully.", HttpStatus.OK);
    }
}

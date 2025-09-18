package com.eventplanner.spring.makevents.event_planner.dtos;

import java.time.LocalDateTime;

import com.eventplanner.spring.makevents.event_planner.models.Event;

public class EventDTO {

    private Long id;

    private String title;

    private String description;

    private String img;

    private LocalDateTime date;

    private String location;

    public EventDTO() {}

    public EventDTO(Event event) {
        this.id = event.getId();
        this.title = event.getTitle();
        this.description = event.getDescription();
        this.img = event.getImg();
        this.date = event.getDate();
        this.location = event.getLocation();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImg() {
        return img;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }
    
    
}

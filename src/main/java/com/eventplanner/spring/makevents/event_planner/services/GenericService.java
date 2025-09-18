package com.eventplanner.spring.makevents.event_planner.services;

import java.util.List;

public interface GenericService <Entity, DTO>{
    List<DTO> findAll();
}

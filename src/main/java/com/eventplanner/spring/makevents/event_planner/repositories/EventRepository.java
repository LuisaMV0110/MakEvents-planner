package com.eventplanner.spring.makevents.event_planner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventplanner.spring.makevents.event_planner.models.Event;


@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
    Event findById(long id);

    Event findByTitle (String title);
}

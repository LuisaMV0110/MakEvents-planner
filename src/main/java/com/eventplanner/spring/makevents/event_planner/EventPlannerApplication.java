package com.eventplanner.spring.makevents.event_planner;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.eventplanner.spring.makevents.event_planner.models.Event;
import com.eventplanner.spring.makevents.event_planner.repositories.EventRepository;

@SpringBootApplication
public class EventPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventPlannerApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(EventRepository eventRepository){
		return args -> {
			Event event1 = new Event("movie", "a fun movie", "url", LocalDateTime.now().plusDays(2), "Movie Theater");
			eventRepository.save(event1);
		};
	}

}

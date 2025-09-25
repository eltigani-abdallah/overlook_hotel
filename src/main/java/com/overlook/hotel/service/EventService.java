package com.overlook.hotel.service;

import com.overlook.hotel.database.Entity.Event;
import com.overlook.hotel.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event details) {
    Event event = getEventById(id);
    event.setEventName(details.getEventName());
    event.setEventDescription(details.getEventDescription());
    event.setEventDate(details.getEventDate());
    return eventRepository.save(event);
}


    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}

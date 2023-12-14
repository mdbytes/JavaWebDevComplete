package com.example.demo.service;

import com.example.demo.dto.EventDto;
import com.example.demo.model.Club;
import com.example.demo.model.Event;
import com.example.demo.repository.ClubRepository;
import com.example.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.dto.mapper.EventMapper.mapToEvent;
import static com.example.demo.dto.mapper.EventMapper.mapToEventDto;


@Service
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;
    private ClubRepository clubRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void createEvent(Integer clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).get();
        Event event = mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }

    @Override
    public List<EventDto> findAll() {
        return eventRepository.findAll().stream().map(event -> mapToEventDto(event)).collect(Collectors.toList());
    }

    @Override
    public List<EventDto> searchEvents(String query) {
        List<Event> events = eventRepository.searchEvents(query);
        return events.stream().map(event -> mapToEventDto(event)).collect(Collectors.toList());
    }

    @Override
    public EventDto findById(Integer id) {
        Event event = eventRepository.findById(id).get();

        return mapToEventDto(event);
    }

    @Override
    public void save(EventDto eventDto) {
        eventRepository.save(mapToEvent(eventDto));
    }

    @Override
    public void updateEvent(EventDto eventDto) {
        Event event = mapToEvent(eventDto);
        eventRepository.save(event);
    }

    @Override
    public void delete(EventDto eventDto) {
        eventRepository.delete(mapToEvent(eventDto));
    }


}

package com.studbaza.baza.controllers;

import com.studbaza.baza.model.Event;
import com.studbaza.baza.model.EventDao;
import com.studbaza.baza.model.EventDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Controller
public class EventController {

    @Autowired
    EventDaoImpl repository;


    @GetMapping("/addEvent")
    public String addEventForm(Model model) {
        Event event = new Event();
        model.addAttribute("event", event);
        return "addEventForm";
    }

    @PostMapping("/addEvent")
    public String addEventFormSubmit(@ModelAttribute @Valid Event event, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "addEventForm";
        repository.create(event.getContent(), event.getDate(), event.getPlaceOfOccurence(), event.getHour());
        return "addEventResult";
    }

    @GetMapping("/getEvent")
    public String getEvent(Model model){
        List<Event> events = repository.listEvents();
        model.addAttribute("events", events);
        return "getEventsResult";
    }

    @GetMapping("/searchForEventsByPlace")
    public String searchForEventsForm(Model model) {
        model.addAttribute("event", new Event());
        return "searchForEvents";
    }

    @PostMapping("/searchForEventsByPlace")
    public String searchForEventsFormSubmit(Model model, @ModelAttribute Event event) {
        if(event.getPlaceOfOccurence().isEmpty()) {
            model.addAttribute("noQueryForSearch", true);
            return "searchForEvents";
        }

        List<Event> events = repository.getEventByPlaceOfOccurence(event.getPlaceOfOccurence());

        if(events.isEmpty()) {
            model.addAttribute("searchIsEmpty", true);
            return "searchForEvents";
        }

        model.addAttribute("events", events);
        return "searchForEventsResult";
    }

}
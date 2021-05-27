package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    //Using List is coding at the interface type, which i better
    //practice, even though it is an arrayList
    private static List<String> events = new ArrayList<>();

    @GetMapping
    public String displayAllEvents(Model model) {

        model.addAttribute("events", events);

        return "events/index";
    }

    //Live at /events/create
    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }

    //Live at /events/create
    //It's okay to live at the same location because one
    //Is get mapping and the other is post, it handles
    //different events, other wise would not work.
    @PostMapping("create")
    public String createEvent(@RequestParam String eventName) {
        events.add(eventName);
        //Because events is the root path it is not needed
        //Can be return "redirect:"
        //Leaving for academic purpose
        return "redirect:/events";
    }
}

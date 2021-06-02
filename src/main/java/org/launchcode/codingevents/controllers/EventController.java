package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAll());

        return "events/index";
    }

    //Live at /events/create
    @GetMapping("create")
    public String renderCreateEventForm(Model model) {
        model.addAttribute("title", "Create Events");
        model.addAttribute(new Event());

        return "events/create";
    }

    //Live at /events/create
    //It's okay to live at the same location because one
    //Is get mapping and the other is post, it handles
    //different events, other wise would not work.
    @PostMapping("create")
    public String createEvent(@ModelAttribute @Valid Event newEvent,
                              Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Events");

            return "events/create";
        }

        EventData.add(newEvent);
        //return "redirect:/events";
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());

        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }

        return "redirect:";
    }

    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId) {
        String title =
                "Edit Event " + EventData.getById(eventId).getName() + "(id=" +
                EventData.getById(eventId).getId() + ")" ;

        model.addAttribute("title", title);

        model.addAttribute("event", EventData.getById(eventId));

        return "events/edit";
    }

    @PostMapping("edit")
    public String processEditForm(@Valid int eventId, String name,
                                  String description, String contactEmail,
                                  Errors errors, Model model) {

        if(errors.hasErrors()){

        }

        EventData.getById(eventId).setName(name);
        EventData.getById(eventId).setDescription(description);
        EventData.getById(eventId).setContactEmail(contactEmail);

        return "redirect:/events";
    }
}

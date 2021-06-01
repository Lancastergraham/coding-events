package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {

    //Need a place to put events
    private static final Map<Integer, Event> events = new HashMap<>();

    //We need behaviors - Get all events
    public static Collection<Event> getAll() {
        return events.values();
    }

    // Get single event
    public static Event getById(int id) {
        return events.get(id);
    }

    // add an event to our collection.
    public static void add(Event event) {
        events.put(event.getId(), event);
    }

    // remove an event from our collection.
    public static void remove (int id) {
        events.remove(id);
    }
}

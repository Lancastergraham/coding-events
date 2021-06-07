package org.launchcode.codingevents.models;

import javax.validation.constraints.*;
import java.util.Objects;


public class Event {
    //Unique Identifier
    private int id;
    private static int nextId = 1;

    @NotBlank
    @Size(min = 2, max = 20, message = "Name must be between 2 and 20" +
            " characters")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @NotBlank(message="Location cannot be left blank.")
    private String location;

    @AssertTrue(message = "Registration must be requried at this time.")
    private boolean registrationRequired;

    private int numberOfAttendees;

    private EventType type;

    public Event(String name, String description, String contactEmail,
                 String location, boolean registrationRequired,
                 int numberOfAttendees,
                 EventType type) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.registrationRequired = registrationRequired;
        this.numberOfAttendees = numberOfAttendees;
        this.type = type;

    }

    public Event(){
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isRegistrationRequired() {
        return registrationRequired;
    }

    public void setRegistrationRequired(boolean registrationRequired) {
        this.registrationRequired = registrationRequired;
    }

    @Positive(message = "Number of attendees must be one or more.")
    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return getId() == event.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

package com.example.pbleventhub;



public class Event extends EvenCreationServlet {

    private String eventName;
    private String eventDate;
    private String eventTime; // Assuming you want a specific time
    private String eventVenue;
    private String eventDescription;
    private String eventType;
    private String ticketOptions;

    // Setter methods
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setTicketOptions(String ticketOptions) {
        this.ticketOptions = ticketOptions;
    }

    // You can also add getter methods if needed
    // ... (getter methods)
}

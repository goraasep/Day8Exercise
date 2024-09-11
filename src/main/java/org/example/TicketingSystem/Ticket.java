package org.example.TicketingSystem;

import java.util.UUID;

public class Ticket implements Ticketable {
    private UUID id;
    private double price;
    private String user;
    private String event;

    Ticket(String user, String event, double price) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.event = event;
        this.price = price;
    }

    @Override
    public String getUUID() {
        return id.toString();
    }

    @Override
    public String getEvent() {
        return this.event;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getUser() {
        return this.user;
    }

}

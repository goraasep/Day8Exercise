package org.example.TicketingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Event {
    private String eventName;
    private int ticketAvailable;
    private double ticketPrice;
    private List<Ticketable> ticketList = new ArrayList<>();

    Event(String eventName, int ticketAvailable, double ticketPrice) {
        this.eventName = eventName;
        this.ticketAvailable = ticketAvailable;
        this.ticketPrice = ticketPrice;
    }

    public String getEventName() {
        return this.eventName;
    }

    public int getTicketAvailability() {
        return this.ticketAvailable;
    }

    public double getTicketPrice() {
        return this.ticketPrice;
    }

    public void buyTicket(String userName) {
        if (this.ticketAvailable > 0) {
            this.ticketAvailable--;
            Ticketable newTicket = new Ticket(userName, this.eventName, this.ticketPrice);
            this.ticketList.add(newTicket);
            System.out.println("======= \t Ticket Sold \t\t=======");
            System.out.println("UUID : " + newTicket.getUUID());
            System.out.println("Event : " + newTicket.getEvent());
            System.out.println("Price : " + newTicket.getPrice());
            System.out.println("User : " + newTicket.getUser());
            System.out.println("Available Tickets : " + this.ticketAvailable);
            System.out.println();
        } else {
            System.out.println("Ticket sold out.");
            System.out.println();
        }
    }

    public List<Ticketable> getAllTickets() {
        return this.ticketList;
    }

    public Ticketable getSingleTicket(String id) {
        boolean exist = false;
        for (Ticketable t : this.ticketList) {
            if (Objects.equals(id, t.getUUID())) {
                return t;
            }
        }
        return null;
    }

    public void checkTicket(String id) {
        boolean exist = false;
        for (Ticketable t : this.ticketList) {
            if (Objects.equals(id, t.getUUID())) {
                System.out.println("UUID : " + t.getUUID());
                System.out.println("Event : " + t.getEvent());
                System.out.println("Price : " + t.getPrice());
                System.out.println("User : " + t.getUser());
                System.out.println();
                break;
            }
        }
        if (!exist) {
            System.out.println("Ticket not found for " + this.eventName + ".");
            System.out.println();
        }
    }

    public void checkAllTicket() {
        if (this.ticketList.isEmpty()) {
            System.out.println("No tickets found for " + this.eventName + ".");
            System.out.println();
        }
        for (Ticketable t : this.ticketList) {
            System.out.println("UUID : " + t.getUUID());
            System.out.println("Event : " + t.getEvent());
            System.out.println("Price : " + t.getPrice());
            System.out.println("User : " + t.getUser());
            System.out.println();
        }
    }

}

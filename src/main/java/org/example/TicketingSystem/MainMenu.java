package org.example.TicketingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private List<Event> eventList = new ArrayList<>();

    public MainMenu() {
        this.eventList.add(new Event("Dufan", 5, 10000));
        this.eventList.add(new Event("Pasar Malam", 1, 20000));
    }

    public void run() {
        System.out.println("======= \t TICKETING SYSTEM \t\t=======");
        System.out.println("1.Check Events");
        System.out.println("2.Book Ticket");
        System.out.println("3.Check Ticket (need UUID)");
        System.out.println("4.Check All Sold Tickets");
        System.out.println("5.Exit");
        System.out.println();
        Scanner scanIn = new Scanner(System.in);
        int selection = Utils.scanInt("Selection : ", scanIn);
        switch (selection) {
            case 1:
                Utils.checkEvents(this.eventList);
                run();
                break;
            case 2:
                //todo book ticket
                TicketProcessing.run(this.eventList, scanIn);
                run();
                break;
            case 3:
                checkTicket(scanIn);
                run();
                break;
            case 4:
                checkAllTickets();
                run();
                break;
            case 5:
                System.out.println("Program closed.");
                break;
            default:
                System.out.println("not available");
                run();
        }
        Utils.closeScanner(scanIn);
    }

    public void checkTicket(Scanner scanner) {
        String id = Utils.scanTicketUUID(scanner);
        Ticketable ticket = null;
        for (Event e : this.eventList) {
            if (e.getSingleTicket(id) != null) {
                ticket = e.getSingleTicket(id);
                break;
            }
        }
        if (ticket != null) {
            System.out.println("UUID : " + ticket.getUUID());
            System.out.println("Event : " + ticket.getEvent());
            System.out.println("Price : " + ticket.getPrice());
            System.out.println("User : " + ticket.getUser());
            System.out.println();
        } else {
            System.out.println("Ticket not found.");
            System.out.println();
        }
    }

    public void checkAllTickets() {
        System.out.println("======= \t Ticket List \t\t=======");
        List<Ticketable> ticketableList = new ArrayList<>();
        for (Event e : this.eventList) {
            ticketableList.addAll(e.getAllTickets());
        }
        if (ticketableList.isEmpty()) {
            System.out.println("Tickets not found.");
            System.out.println();
        } else {
            for (Ticketable t : ticketableList) {
                System.out.println("UUID : " + t.getUUID());
                System.out.println("Event : " + t.getEvent());
                System.out.println("Price : " + t.getPrice());
                System.out.println("User : " + t.getUser());
                System.out.println();
            }
        }
    }
}

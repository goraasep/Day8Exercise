package org.example.TicketingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicketProcessing {
    public static void run(List<Event> eventList, Scanner scanner) {
        Utils.checkEvents(eventList);
        int numberEvent = Utils.scanNumberEvent(scanner) - 1;
        if (numberEvent >= eventList.size()) {
            System.out.println("Event is not available.");
            System.out.println();
            return;
        }
        if (eventList.get(numberEvent).getTicketAvailability() == 0) {
            System.out.println("Ticket sold out.");
            System.out.println();
            return;
        }
        Utils.checkSingleEvent(eventList.get(numberEvent));
        eventList.get(numberEvent).buyTicket(Utils.scanUserName(scanner));
    }


}

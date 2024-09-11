package org.example.TicketingSystem;

import java.util.List;
import java.util.Scanner;

public class Utils {
    static int scanInt(String text, Scanner scanner) {
        System.out.print(text);
        scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Input is not integer.");
            return scanInt(text, scanner);
        }
    }

    public static void closeScanner(Scanner scanner) {
        try {
            scanner.close();
        } catch (IllegalStateException e) {
            System.out.println("Scanner is already closed.");
        }
    }

    static void checkEvents(List<Event> eventList) {
        System.out.println("======= \t Available Events \t\t=======");
        int i = 1;
        for (Event e : eventList) {
            System.out.println(i + ". " + e.getEventName());
            System.out.println("Price : " + e.getTicketPrice());
            System.out.println("Tickets Available : " + e.getTicketAvailability());
            i++;
        }
        System.out.println();
    }

    static void checkEventsNames(List<Event> eventList) {
        System.out.println("======= \t Available Events \t\t=======");
        int i = 1;
        for (Event e : eventList) {
            System.out.println(i + ". " + e.getEventName());
            i++;
        }
        System.out.println();
    }

    static void checkSingleEvent(Event event) {
        System.out.println("Event : " + event.getEventName());
        System.out.println("Price : " + event.getTicketPrice());
        System.out.println("Tickets Available : " + event.getTicketAvailability());
        System.out.println();
    }

    static String scanTicketUUID(Scanner scanner) {
        System.out.print("Ticket UUID : ");
        scanner = new Scanner(System.in);
        try {
            return scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return scanTicketUUID(scanner);
        }
    }

    static String scanUserName(Scanner scanner) {
        System.out.print("User Name : ");
        scanner = new Scanner(System.in);
        try {
            return scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return scanUserName(scanner);
        }
    }

    static int scanNumberEvent(Scanner scanner) {
        System.out.print("Event : ");
        scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Input is not integer.");
            return scanNumberEvent(scanner);
        }
    }
}

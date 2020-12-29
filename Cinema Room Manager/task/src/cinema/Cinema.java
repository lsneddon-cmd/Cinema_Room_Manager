package cinema;

import java.util.Scanner;
import java.util.stream.Stream;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IBookingManager bookingManager = initialiseVenue(scanner);
        menuLoop(scanner, bookingManager);
    }

    public static void menuLoop(Scanner scanner, IBookingManager bookingManager) {
        boolean exit = false;
        int menuChoice;
        while (!exit) {
            printMenu();
            menuChoice = scanner.nextInt();
            scanner.nextLine();
            boolean booked = false;

            switch (menuChoice) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    bookingManager.print();
                    break;
                case 2:
                    while (!booked) {
                        try {
                            bookingManager.buyTicket(scanner);
                            booked = true;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 3:
                    bookingManager.printStats();
            }
        }
    }

    public static TheatreBookingManager initialiseVenue(Scanner scanner) {
        String[] prompts = {
                "Enter the number of rows:",
                "Enter the number of seats in each row:"
        };
        // Collect input
        System.out.println(prompts[0]);
        int rows = scanner.nextInt();
        scanner.nextLine();
        System.out.println(prompts[1]);
        int cols = scanner.nextInt();
        scanner.nextLine();

        // Get Booking manager instance
        return TheatreBookingManager.getInstance(new Theatre(rows, cols));
    }

    public static void printMenu() {
        String[] menu = {
                "1. Show the seats",
                "2. Buy a ticket",
                "3. Statistics",
                "0. Exit"
        };
        Stream.of(menu)
                .forEach(System.out::println);
    }
}
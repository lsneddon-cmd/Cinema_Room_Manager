package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IBookingManager bookingManager = initialiseVenue(scanner);

        boolean exit = false;
        int menuChoice;
        while (!exit) {
            printMenu();
            menuChoice = scanner.nextInt();
            scanner.nextLine();

            switch (menuChoice) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    bookingManager.print();
                    break;
                case 2:
                    bookingManager.buyTicket(scanner);
                    break;
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

        // Create booking manager
        Theatre cinema = new Theatre(rows, cols);
        return new TheatreBookingManager(cinema);
    }

    public static void printMenu() {
        String[] menu = {
                "1. Show the seats",
                "2. Buy a ticket",
                "0. Exit"
        };
        for (String item : menu) {
            System.out.println(item);
        }
    }
}
package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
        IBookingManager bookingManager = new TheatreBookingManager(cinema);
        cinema.printFormatted();

        // Book a seat
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();
        row--; // Account for zero indexing
        scanner.nextLine();
        System.out.println("Enter a seat number in that row:");
        int col = scanner.nextInt();
        col--; // Account for zero indexing
        scanner.nextLine();
        System.out.println();
        System.out.println("Ticket price: $" + bookingManager.getSeatPrice(row, col));
        bookingManager.bookSeat(row, col);
        System.out.println();
        bookingManager.print();
    }
}
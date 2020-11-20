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
        bookingManager.printMaxProfit();
    }
}
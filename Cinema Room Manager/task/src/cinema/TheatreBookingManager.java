package cinema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheatreBookingManager implements IBookingManager {
    Theatre cinema;
    List<Ticket> tickets;

    public TheatreBookingManager(Theatre cinema) {
        this.cinema = cinema;
        tickets = new ArrayList<>();
        for (int i = 0; i < cinema.getRows(); i++) {
            for (int j = 0; j < cinema.getCols(); j++) {
                tickets.add(generateTicket(i, j));
            }
        }
    }

    @Override
    public int calculateMaxProfit() {
        int total = 0;
        for (Ticket ticket : tickets) {
            total += ticket.getPrice();
        }
        return total;
    }

    @Override
    public void printMaxProfit() {
        System.out.println("Total income:");
        System.out.print("$");
        System.out.println(calculateMaxProfit());
    }

    @Override
    public Ticket generateTicket(int row, int col) {
        if (cinema.getTotalSeats() < 61) {
            return new Ticket(row, col, 10);
        } else if (row < cinema.getRows() / 2) {
            return new Ticket(row, col, 10);
        } else {
            return new Ticket(row, col, 8);
        }
    }

    @Override
    public boolean bookSeat(int row, int col) {
        if (checkAvailableSeat(row, col)) {
            cinema.updateContent(row, col, 'B');
            for (Ticket ticket : tickets) {
                if (ticket.getRow() == row && ticket.getCol() == col) {
                    ticket.setBooked(true);
                }
            }
        }
        return false;
    }

    @Override
    public int getSeatPrice(int row, int col) {
        for (Ticket ticket : tickets) {
            if (ticket.getRow() == row && ticket.getCol() == col) {
                return ticket.getPrice();
            }
        }
        return -1;
    }

    @Override
    public boolean checkAvailableSeat(int row, int col) {
        for (Ticket ticket : tickets) {
            if (ticket.getRow() == row && ticket.getCol() == col) {
                return !ticket.getBooked();
            }
        }
        return false;
    }

    @Override
    public void print() {
        cinema.printFormatted();
    }

    @Override
    public void buyTicket(Scanner scanner) {
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();
        row--; // Account for zero indexing
        scanner.nextLine();
        System.out.println("Enter a seat number in that row:");
        int col = scanner.nextInt();
        col--; // Account for zero indexing
        scanner.nextLine();
        System.out.println();
        System.out.println("Ticket price: $" + getSeatPrice(row, col));
        bookSeat(row, col);
    }
}

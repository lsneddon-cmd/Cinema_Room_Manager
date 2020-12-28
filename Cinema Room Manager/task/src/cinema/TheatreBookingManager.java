package cinema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheatreBookingManager implements IBookingManager {
    private final Theatre cinema;
    private List<Ticket> tickets;
    private int purchasedTickets;
    private int currentIncome;

    public TheatreBookingManager(Theatre cinema) {
        this.cinema = cinema;
        tickets = new ArrayList<>();
        // TODO As we don't random access, tickets is better as Linked List
        for (int i = 0; i < cinema.getRows(); i++) {
            for (int j = 0; j < cinema.getCols(); j++) {
                tickets.add(generateTicket(i, j));
            }
        }
        this.purchasedTickets = 0;
        this.currentIncome = 0;
    }

    @Override
    public int calculateMaxProfit() {
        return tickets.stream()
                .map(t -> t.getPrice())
                .mapToInt(Integer::intValue)
                .sum();
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
                    purchasedTickets++;
                    currentIncome += ticket.getPrice();
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
    public void buyTicket(Scanner scanner) throws Exception {
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();
        row--; // Account for zero indexing
        scanner.nextLine();
        System.out.println("Enter a seat number in that row:");
        int col = scanner.nextInt();
        col--; // Account for zero indexing
        scanner.nextLine();
        System.out.println();

        if (row >= cinema.getRows() || col >= cinema.getCols()) {
            throw new Exception("Wrong input");
        }

        if (checkAvailableSeat(row, col)) {
            bookSeat(row, col);
        } else {
            throw new Exception("That ticket has already been purchased!");
        }

        System.out.println("Ticket price: $" + getSeatPrice(row, col));
    }

    @Override
    public void printStats() {
        System.out.println("Number of purchased tickets: " + purchasedTickets);
        double percentage = ((double)purchasedTickets / (double)cinema.getTotalSeats()) * 100;
        System.out.printf("Percentage: %.2f", percentage);
        System.out.println("%");
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + calculateMaxProfit());
    }
}

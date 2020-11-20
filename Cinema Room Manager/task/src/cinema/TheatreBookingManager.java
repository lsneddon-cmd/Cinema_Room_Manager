package cinema;

import java.util.ArrayList;
import java.util.List;

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
}

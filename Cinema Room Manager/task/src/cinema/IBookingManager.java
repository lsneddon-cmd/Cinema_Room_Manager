package cinema;

import java.util.Scanner;

public interface IBookingManager {
    int calculateMaxProfit();
    void printMaxProfit();
    Ticket generateTicket(int row, int col);
    void bookSeat(int row, int col) throws Exception;
    int getSeatPrice(int row, int col) throws Exception;
    boolean checkAvailableSeat(int row, int col);
    void print();
    void buyTicket(Scanner scanner) throws Exception;
    void printStats();
}

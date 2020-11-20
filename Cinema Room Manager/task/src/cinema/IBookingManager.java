package cinema;

public interface IBookingManager {
    int calculateMaxProfit();
    void printMaxProfit();
    Ticket generateTicket(int row, int col);
}

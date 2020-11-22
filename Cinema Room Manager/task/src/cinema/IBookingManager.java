package cinema;

public interface IBookingManager {
    int calculateMaxProfit();
    void printMaxProfit();
    Ticket generateTicket(int row, int col);
    boolean bookSeat(int row, int col);
    int getSeatPrice(int row, int col);
    boolean checkAvailableSeat(int row, int col);
    void print();
}

package cinema;

public class Ticket {
    private int price;
    private int row;
    private int col;
    private boolean booked;

    public Ticket(int row, int col, int price) {
        this.row = row;
        this.col = col;
        this.price = price;
        this.booked = false;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getPrice() {
        return price;
    }

    public boolean getBooked() {
        return booked;
    }

    public void setBooked() {
        this.booked = true;
    }
}

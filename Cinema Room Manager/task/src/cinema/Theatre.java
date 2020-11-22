package cinema;

import java.util.Arrays;

public class Theatre implements IMatrix {
    // TODO Theatre should implement a new interface IVenue that extends IMatrix
    private int rows;
    private int cols;
    char[][] matrix;
    private int totalSeats;

    public Theatre(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.totalSeats = rows * cols;
        matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(matrix[i], 'S');
        }
    }

    public Theatre() {
        this.rows = 7;
        this.cols = 8;
        this.totalSeats = rows * cols;
        matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(matrix[i], 'S');
        }
    }

    public void printFormatted() {
        // Top Line
        System.out.println("Cinema:");
        // Column headings
        System.out.print(" ");
        for (int i = 0; i < cols; i++) {
            System.out.print(" " + (i+1));
        }
        System.out.println();
        // Rows
        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < cols; j++) {
                System.out.print(" ");
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public void updateContent(int row, int col, char newContent) {
        matrix[row][col] = newContent;
    }

    @Override
    public char showContent(int row, int col) {
        return matrix[row][col];
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int getTotalSeats() {
        return totalSeats;
    }
}

package cinema;

import java.util.Arrays;
import java.util.stream.Stream;

public class Theatre implements IMatrix {
    private final int rows;
    private final int cols;
    char[][] matrix;
    private final int totalSeats;

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
        this(7, 8);
    }

    public void printFormatted() {
        // Top Line
        System.out.println("Cinema:");
        // Column headings
        System.out.print(" ");
        Stream.iterate(1, i -> i <= cols, i -> i + 1)
            .forEach(i -> System.out.print(" " + i));
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

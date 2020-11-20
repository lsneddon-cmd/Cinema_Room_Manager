package cinema;

import java.util.Arrays;

public class Theatre implements IMatrix {
    private int rows;
    private int cols;
    char[][] matrix;

    public Theatre() {
        this.rows = 7;
        this.cols = 8;
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

    public boolean updateContent() {
        return true;
    }

    public char showContent() {
        return 'S';
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }
}

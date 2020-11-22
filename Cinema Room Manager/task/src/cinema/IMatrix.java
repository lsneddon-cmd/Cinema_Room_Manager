package cinema;

public interface IMatrix {
    void printFormatted();
    void updateContent(int row, int col, char newContent);
    char showContent(int row, int col);
}

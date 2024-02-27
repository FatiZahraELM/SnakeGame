package fr.norsys;

public class Board {
    static int ROW_COUNT;
    static int COL_COUNT;

    private Cell[][] cells;

    public Cell[][] getCells() {
        return cells;
    }

    public Board(int rowCount, int columnCount)
    {
        ROW_COUNT = rowCount;
        COL_COUNT = columnCount;

        cells = new Cell[ROW_COUNT][COL_COUNT];
        for (int row = 0; row < ROW_COUNT; row++) {
            for (int column = 0; column < COL_COUNT;
                 column++) {
                cells[row][column] = new Cell(row, column);
            }
        }
    }
}

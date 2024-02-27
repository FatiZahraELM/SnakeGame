package fr.norsys;

public class Cell {
    private int row;
    private int column;

    private CellStatus cellStatus;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }

    public Cell(int row, int col)
    {
        this.row = row;
        this.column = col;
    }

}

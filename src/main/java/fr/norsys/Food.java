package fr.norsys;

public class Food {


    private Cell foodPosition;

    public Cell getFoodPosition() {
        return foodPosition;
    }
    public Food(){

    }

    public Food(Cell foodPosition) {
        this.foodPosition = foodPosition;
    }
    public void setFoodPosition(Cell foodPosition) {
        this.foodPosition = foodPosition;
    }
    public Food generateFood()
    {
        int row = 0, column = 0;
        Cell position = new Cell(row,column);
        while (true) {
            row = (int)(Math.random() * Board.ROW_COUNT);
            column = (int)(Math.random() * Board.COL_COUNT);
            if (foodPosition.getCellStatus() != CellStatus.SNAKE)
                break;
        }
        position.setCellStatus(CellStatus.FOOD);
        position.setRow(row);
        position.setColumn(column);
        return  new Food (position);
    }

}

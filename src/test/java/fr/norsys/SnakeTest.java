package fr.norsys;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SnakeTest {

    @Test
    public void foodTest(){
        Board board=new Board(40,40);
        Food food=new Food();
        Cell position = new Cell(0,0);
        food.setFoodPosition(position);
        int row=food.getFoodPosition().getRow();
        System.out.println( row);
    }
    @Test
    public void isDirectionAllowedTest(){
        Board board=new Board(40,40);
        Cell nextCell =new Cell(4,8);
        nextCell.setCellStatus(CellStatus.EMPTY);
        Cell head=new Cell(3,8);
        Snake snake=new Snake( head,Direction.RIGHT);
        assertTrue(snake.isDirectionAllowed(nextCell));
    }
    @Test
    public void turnTest(){
        Board board=new Board(40,40);
        Cell nextCell =new Cell(4,8);
        nextCell.setCellStatus(CellStatus.EMPTY);
        Cell head=new Cell(3,8);
        Snake snake=new Snake( head,Direction.RIGHT);
        snake.turn(nextCell);
    }
     @Test
    public void getNextCellTest(){
        Board board=new Board(40,40);
        Cell nextCell =new Cell(4,8);
        nextCell.setCellStatus(CellStatus.EMPTY);
        Cell head=new Cell(3,8);
        Snake snake=new Snake( head,Direction.RIGHT);
        Cell c=new Cell(3,9);
        System.out.println(c.getRow()+", "+c.getColumn());
        System.out.println(snake.getNextCell(head).getRow()+", "+snake.getNextCell(head).getColumn());

    }
    @Test
    public void eatTest(){
        Board board=new Board(40,40);
        Cell nextCell =new Cell(4,8);
        nextCell.setCellStatus(CellStatus.EMPTY);
        Cell head=new Cell(3,8);
        Snake snake=new Snake( head,Direction.RIGHT);
        System.out.println(snake.getSnakeBody().size());  // expected 1
        snake.eat(new Food(nextCell));
        // now the next cell that contains food is a mart of  the snake body
        // and the size of it has been increesed
        String expected= "4, 8, SNAKE, 2";
    }

}

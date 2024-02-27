package fr.norsys;

import java.util.Timer;

public class SnakeGame {
    private boolean gameOver = false;
    private Snake snake;
    private Score score;
    private Board board;
    private Timer timer;
    private Food food;

    public SnakeGame(Snake snake, Board board) {
        this.snake = snake;
        this.board = board;
        this.score=new Score();
        this.food.generateFood();


    }

    public void startGame(){
        Cell head=new Cell(1,2);
        Snake snake=new Snake(head,Direction.RIGHT);
        Board board=new Board(100,100);
        SnakeGame snakeGame=new SnakeGame(snake,board);
    }
    public void endgame() {
        gameOver = true;
        score.resetScore();
    }
    public boolean isGameOver() { return gameOver; }

    public void setGameOver(boolean gameOver)
    {
        this.gameOver = gameOver;
    }
    public void update() {
        if (!gameOver) {
            if (snake.getSnakeDirection() != Direction.DIRECTION_NONE) {
                Cell nextCell = snake.getNextCell(snake.getHead());
                if (snake.getHead() == food.getFoodPosition() && snake.getHead() == food.getFoodPosition()) {
                    snake.eat(food);
                    score.increaseScore();
                }
                snake.move(nextCell);

                if (gameOver) {
                    endgame();

                }
            }
        }
    }
}
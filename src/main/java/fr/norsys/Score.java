package fr.norsys;

public class Score {
    private int score;
    public Score(){
        this.score=0;

    }
    public void increaseScore(){
        score++;
    }
    public void resetScore(){
        this.score=0;

    }

    public int getScore() {
        return score;
    }
}

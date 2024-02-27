package fr.norsys;

public enum Direction {
    LEFT("left"),
    RIGHT("right"),

    UP("up"),
    DOWN("down"),
    DIRECTION_NONE("none");

    private final String direction;


    Direction(String direction){
    this.direction=direction;
    }


}

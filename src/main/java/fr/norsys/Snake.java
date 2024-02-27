package fr.norsys;

public class Snake {
    // A boolean used to check if the game is ended
    boolean gameover = false;

    // A general size used for the objective
// and snake head and tail
    float s = 5;

    // All the positions of the snake's head and tail
// snakePositions.get(0) => head
// snakePositions.get(n > 0) => tail
    ArrayList<PVector> snakePositions = new ArrayList<PVector>();

    // The direction of the snake
    PVector snakeDirection = new PVector(1, 0);

    // The position of the objective
    PVector objPosition = new PVector(0, 0);

    // A method used to check if two vectors overlaps
    public boolean overlaps(PVector p1, PVector p2) {
        PVector c1 = new PVector(p1.x + s/2, p1.y + s/2);
        PVector c2 = new PVector(p2.x + s/2, p2.y + s/2);
        return PVector.dist(c1, c2) < s;
    }

    // A method used to randomize the position
// of a vector within the boundaries
    public void randomize(PVector position, float a, float b) {
        position.x = random(a, b);
        position.y = random(a, b);
    }

    // A method used to end the game
    public void endgame() {
        gameover = true;

        // Show a black screen
        background(0);
        // Set text color
        fill(255);
        // Show game over text
        text("Gameover", 10, 20);
    }

    // A method used to reset the game
    public void reset() {
        gameover = false;

        // Clear the positions
        snakePositions.clear();

        // Get screen center position
        PVector c = new PVector(width/2, height/2);

        // Add the snake's head
        snakePositions.add(c);

        // Randomize the position of the obj.
        randomize(objPosition, 0, width-s);
    }

    void setup() {
        // Set the application's frame rate
        // Lower frame rate = slower movement
        // Higher frame rame = faster movement
        frameRate(15);

        // Reset the game
        reset();
    }

    void draw() {
        // Set background color
        background(0);

        // If the game ended
        if (gameover) {
            // Wait 5 seconds
            delay(5000);
            // Reset the game
            reset();
            return;
        }

        // Draw score
        fill(255);
        text("Score: " + (snakePositions.size()-1), 10, 20);

        // Set snake and objective
        // fill and stroke color
        fill(0);
        stroke(255);

        // Draw the objective
        rect(objPosition.x, objPosition.y, s, s);

        // Draw the snake
        for (int i = snakePositions.size() - 1; i > -1; i--) {

            // Get the current position
            PVector position = snakePositions.get(i);

            // If the position is the head
            if (i == 0) {
                // Move towards the direction
                position.x += snakeDirection.x * s;
                position.y += snakeDirection.y * s;

                // Check if the position is outside
                // the screen's borders
                // Horizontal
                if (position.x < 0) position.x = width;
                else if (position.x > width) position.x = 0;
                // Vertical
                if (position.y < 0) position.y = height;
                else if (position.y > height) position.y = 0;

                // Check if the head overlaps with
                // the objective
                if (overlaps(position, objPosition)) {
                    // Randomize the position of the obj.
                    randomize(objPosition, 0, width-s);
                    // Increase the snake's tail
                    PVector last = snakePositions.get(snakePositions.size() - 1);
                    PVector next = new PVector(last.x-(snakeDirection.x*s), last.y-(snakeDirection.x*s));
                    snakePositions.add(next);
                }

            } else {
                // Check if the tail overlaps with the head
                // Unless it's the point attached directly to the head
                if (i > 1 && overlaps(position, snakePositions.get(0))) {
                    endgame();
                    break;
                } else {
                    // Get the position before
                    PVector before = snakePositions.get(i - 1);
                    // Set the current element's position to the position before
                    position.x = before.x;
                    position.y = before.y;
                }
            }

            // Display the point
            rect(position.x, position.y, s, s);
        }
    }

    void keyPressed() {
        if (key == 'a' && snakeDirection.x != 1) {
            snakeDirection.x = -1;
            snakeDirection.y = 0;
        }
        else if (key == 'd' && snakeDirection.x != -1) {
            snakeDirection.x = 1;
            snakeDirection.y = 0;
        }
        else if (key == 's' && snakeDirection.y != -1) {
            snakeDirection.x = 0;
            snakeDirection.y = 1;
        }
        else if (key == 'w' && snakeDirection.y != 1) {
            snakeDirection.x = 0;
            snakeDirection.y = -1;
        }
    }
}

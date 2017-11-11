package ca.bcit.cst.rongyi.game;

/**
 * Tile
 *
 * @author Rongyi Chen
 * @version 2017
 */
public class Tile {
    private static final int DEFAULT_SPEED = 5;
    private static final int PIXEL_PER_SPEED = 50;
    
    private int speed;
    
    private final int column;
    private int y;
    
    public Tile(int column) {        
        this.setSpeed(DEFAULT_SPEED);
        this.column = column;
        this.y = 0;
    }
    
    public void move() {
        y += (int) ((double) speed / (double) GameLoop.framesPerSecond);
    }

    private void setSpeed(int speed) {
        this.speed = speed * PIXEL_PER_SPEED;
    }
    
    /**
     * Returns the column for this Tile.
     * @return the column
     */
    public int getColumn() {
        return column;
    }

    /**
     * Returns the y for this Tile.
     * @return the y
     */
    public int getY() {
        return y;
    }
}

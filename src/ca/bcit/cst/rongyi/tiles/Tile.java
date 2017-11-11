package ca.bcit.cst.rongyi.tiles;

import ca.bcit.cst.rongyi.game.GameLoop;

/**
 * Tile is the piano tile.
 *
 * @author Rongyi Chen
 * @version 2017
 */
public class Tile {

    /** Tile's default speed. */
    private static final int DEFAULT_SPEED = 15;
    /** 1 speed for 50 pixels per second. */
    private static final int PIXEL_PER_SPEED = 50;

    /** moving speed at pixel per second. */
    private int speed;

    /** column number. */
    private final int column;
    /** y position. */
    private int y;

    /**
     * Constructs an object of type Tile.
     * 
     * @param column
     *            column number as an integer
     */
    public Tile(int column) {
        this.setSpeed(DEFAULT_SPEED);
        this.column = column;
        this.y = 0;
    }

    /**
     * Moves the tile in one frame rate.
     */
    public void move() {
        y += (int) ((double) speed / (double) GameLoop.getFramesPerSecond());
    }

    /**
     * Set the moving speed of the tile.
     * 
     * @param speed
     *            as an integer
     */
    private void setSpeed(int speed) {
        this.speed = speed * PIXEL_PER_SPEED;
    }

    /**
     * Returns the column for this Tile.
     * 
     * @return the column
     */
    public int getColumn() {
        return column;
    }

    /**
     * Returns the y for this Tile.
     * 
     * @return the y
     */
    public int getY() {
        return y;
    }
}

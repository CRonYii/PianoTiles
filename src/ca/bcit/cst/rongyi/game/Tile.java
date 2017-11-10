package ca.bcit.cst.rongyi.game;

/**
 * Tile
 *
 * @author Rongyi Chen
 * @version 2017
 */
public class Tile {
    private int speed;
    
    private final int column;
    private int y;
    
    public Tile(int column) {        
        this.speed = 10;
        this.column = column;
        this.y = 0;
    }
    
    public void move() {
        y += speed;
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

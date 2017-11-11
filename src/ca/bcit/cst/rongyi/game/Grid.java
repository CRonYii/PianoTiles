package ca.bcit.cst.rongyi.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javafx.scene.paint.Color;

/**
 * Grid
 *
 * @author Rongyi Chen
 * @version 2017
 */
public class Grid {

    private final int SIZE_WIDTH;
    private final int SZIE_HEIGHT;
    private final int width;
    private final int height;

    public final Color BACKGROUND_COLOR = Color.SILVER;
    public final Color LINE_COLOR = Color.BLACK;

    private TileGrid tileGrid;

    public Grid(int width, int height) {
        this.SIZE_WIDTH = width / GameLoop.KEYS;
        this.SZIE_HEIGHT = (int) (this.SIZE_WIDTH / 5.0);
        
        this.width = width;
        this.height = height;
        
        tileGrid = new TileGrid(height);
        
    }

    public void update() {
        tileGrid.perform();
    }

    /**
     * Remove the first tile in the appointed column, return true if succeed.
     * 
     * @param column
     *            int
     * @return true if succeed, false otherwise
     */
    public boolean removeTile(int column) {
        TileList list = tileGrid.getTilesList()[column];
        if (list.size() != 0) {
            list.remove(0);
            return true;
        }
        return false;
    }

    /**
     * Returns the width for this Grid.
     * 
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height for this Grid.
     * 
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns the sIZE for this Grid.
     * 
     * @return the sIZE
     */
    public int getSIZE_WIDTH() {
        return SIZE_WIDTH;
    }

    /**
     * Returns the sZIE_HEIGHT for this Grid.
     * 
     * @return the sZIE_HEIGHT
     */
    public int getSZIE_HEIGHT() {
        return SZIE_HEIGHT;
    }


    /**
     * Returns the tileGrid for this Grid.
     * @return the tileGrid
     */
    public TileGrid getTileGrid() {
        return tileGrid;
    }

}

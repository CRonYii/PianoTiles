package ca.bcit.cst.rongyi.tiles;

import java.util.Iterator;
import java.util.LinkedList;

import javafx.scene.paint.Color;

/**
 * TileList
 *
 * @author Rongyi Chen
 * @version 2017
 */
public class TileList extends LinkedList<Tile> {

    private static final Color ODD_COLUMN_COLOR = Color.WHITE;
    private static final Color EVEN_COLUMN_COLOR = Color.BLACK;
    private static final double chanceOfGeneration = 0.5;

    /** Tile Color of this column. */
    public final Color tileColor;

    /** Column number. */
    private final int column;
    /** the time last generated a tile. */
    private long lastGeneratedTime;

    /**
     * Constructs an object of type TileList.
     * 
     * @param column
     *            column number as an integer
     */
    public TileList(int column) {
        super();
        this.column = column;
        this.tileColor = (column % 2 == 0) ? EVEN_COLUMN_COLOR : ODD_COLUMN_COLOR;
    }

    /**
     * Performs.
     */
    public void perform() {
        generateTile();
        move();
        clearUnusedTiles();
    }

    /**
     * Generate Tiles for this column.
     */
    public void generateTile() {
        if (canGenerate()) {
            if (Math.random() > chanceOfGeneration) {
                this.add(new Tile(column));
            }
            lastGeneratedTime = System.currentTimeMillis();
        }
    }

    /**
     * Move the tiles in the list.
     */
    public void move() {
        Iterator<Tile> iterator = this.iterator();
        while (iterator.hasNext()) {
            Tile temp = iterator.next();
            temp.move();
        }
    }

    /**
     * Clean the list, remove unused tiles.
     */
    public void clearUnusedTiles() {
        Iterator<Tile> iterator = this.iterator();
        while (iterator.hasNext()) {
            Tile temp = iterator.next();
            if (temp.getY() >= TileGrid.getHeight()) {
                iterator.remove();
            }
        }
    }

    /**
     * Check if time has passed enough to generate another tile.
     * 
     * @return true if generatable, false otherwise
     */
    private boolean canGenerate() {
        return (System.currentTimeMillis() - lastGeneratedTime > TileGrid.RANDOM_GENERATION_TIME);
    }
}

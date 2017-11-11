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

    private final long generateTime;
    private long[] lastGenerated;

    public final Color BACKGROUND_COLOR = Color.SILVER;
    public final Color LINE_COLOR = Color.BLACK;

    private List<Tile>[] tileLists;

    @SuppressWarnings("unchecked")
    public Grid(int width, int height) {
        this.SIZE_WIDTH = width / GameLoop.KEYS;
        this.SZIE_HEIGHT = (int) ((9.0 / 16.0) * this.SIZE_WIDTH);
        this.width = width;
        this.height = height;
        this.generateTime = 200;
        this.tileLists = (List<Tile>[]) new List[GameLoop.KEYS];
        for (int i = 0; i < GameLoop.KEYS; i++) {
            tileLists[i] = new ArrayList<>();
        }
        this.lastGenerated = new long[GameLoop.KEYS];
    }

    public void update() {
        generateTile();
        for (int i = 0; i < GameLoop.KEYS; i++) {
            Iterator<Tile> iterator = tileLists[i].iterator();
            while (iterator.hasNext()) {
                Tile temp = iterator.next();
                temp.move();
                if (temp.getY() >= height) {
                    iterator.remove();
                }
            }
        }
    }

    private void generateTile() {
        for (int i = 0; i < GameLoop.KEYS; i++) {
            if (System.currentTimeMillis() - lastGenerated[i] > generateTime) {
                Random rnd = new Random();
                if (rnd.nextFloat() > 0.75) {
                    tileLists[i].add(new Tile(i));
                }
                lastGenerated[i] = System.currentTimeMillis();
            }
        }
    }

    /**
     * Remove the first tile in the appointed column, return true if succeed
     * 
     * @param column
     *            int
     * @return true if succeed, false otherwise
     */
    public boolean removeTile(int column) {
        if (tileLists[column].size() != 0) {
            tileLists[column].remove(0);
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
     * Returns the tileList for this Grid.
     * 
     * @return the tileList
     */
    public List<Tile>[] getTileLists() {
        return tileLists;
    }

}

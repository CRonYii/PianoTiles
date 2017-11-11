package ca.bcit.cst.rongyi.tiles;

import ca.bcit.cst.rongyi.game.GameLoop;

/**
 * TilesList
 *
 * @author Rongyi Chen
 * @version 2017
 */
public class TileGrid {

    public static final double BPM = 165.0;
    public static final long RANDOM_GENERATION_TIME = (long) (1000.0 / (BPM / 60));
    private static int height;
    
    private TileList[] tilesList;

    /**
     * Constructs an object of type TileGrid.
     */
    public TileGrid(int height) {
        this.height = height;
        tilesList = new TileList[GameLoop.KEYS];
        for (int i = 0; i < GameLoop.KEYS; i++) {
            tilesList[i] = new TileList(i);
        }
    }

    /**
     * Performs.
     */
    public void perform() {
        for (TileList list: tilesList) {
            list.perform();
        }
    }

    /**
     * Returns the tilesList for this TileGrid.
     * @return the tilesList
     */
    public TileList[] getTilesList() {
        return tilesList;
    }

    /**
     * Returns the height for this TileGrid.
     * @return the height
     */
    public static int getHeight() {
        return height;
    }

}

package ca.bcit.cst.rongyi.game;

import ca.bcit.cst.rongyi.gui.Painter;
import javafx.scene.canvas.GraphicsContext;

/**
 * GameLoop is the loop of the game.
 *
 * @author Rongyi Chen
 * @version 2017
 */
public class GameLoop implements Runnable {
    /** The number of keys in the game. */
    public static final int KEYS = 4;
    /** frame rate of the game. */
    private static int framesPerSecond = 60;

    private Grid grid;
    private Painter painter;

    /** interval is the time gap between each frame in milliseconds. */
    private final long interval = 1000 / framesPerSecond;

    private boolean running = true;
    private boolean pause = false;

    /**
     * Constructs an object of type GameLoop.
     * 
     * @param grid
     *            the game grid
     * @param context
     *            the canvas context to draw on
     */
    public GameLoop(Grid grid, GraphicsContext context) {
        this.grid = grid;
        this.painter = new Painter(grid, context);
    }

    @Override
    public void run() {
        while (running && !pause) {
            perform();
        }
    }

    /**
     * Performs the game.
     */
    private void perform() {
        long time = System.currentTimeMillis();
        
        grid.update();
        painter.paint();

        time = System.currentTimeMillis() - time;
        if (time < interval) {
            try {
                Thread.sleep(interval - time);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * Returns the pause for this GameLoop.
     * 
     * @return the pause
     */
    public boolean isPause() {
        return pause;
    }

    /**
     * Sets the pause for this GameLoop.
     * 
     * @param pause
     *            the pause to set
     */
    public void setPause(boolean pause) {
        this.pause = pause;
    }

    /**
     * Let game pause if running, let game resume if is paused.
     */
    public void togglePause() {
        pause = !pause;
        if (!pause) {
            (new Thread(this, "GameLoop")).start();
        }
    }

    /**
     * Returns the framesPerSecond for this GameLoop.
     * @return the framesPerSecond
     */
    public static int getFramesPerSecond() {
        return framesPerSecond;
    }

    /**
     * Sets the framesPerSecond for this GameLoop.
     * @param framesPerSecond the framesPerSecond to set
     */
    public static void setFramesPerSecond(int framesPerSecond) {
        GameLoop.framesPerSecond = framesPerSecond;
    }

}

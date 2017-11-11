package ca.bcit.cst.rongyi.game;

import ca.bcit.cst.rongyi.gui.Painter;
import javafx.scene.canvas.GraphicsContext;

/**
 * GameLoop
 *
 * @author Rongyi Chen
 * @version 2017
 */
public class GameLoop implements Runnable {
    public static final int KEYS = 4;
    public static int framesPerSecond = 120;

    private Grid grid;
    private Painter painter;

    private final long interval;

    private boolean running;
    private boolean pause;

    public GameLoop(Grid grid, GraphicsContext context) {
        this.grid = grid;
        painter = new Painter(grid, context);

        interval = 1000 / framesPerSecond;

        running = true;
        pause = false;
    }

    @Override
    public void run() {
        while (running && !pause) {
            perform();
        }
    }

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

    public void togglePause() {
        pause = !pause;
        if (!pause) {
            (new Thread(this, "GameLoop")).start();
        }
    }

}

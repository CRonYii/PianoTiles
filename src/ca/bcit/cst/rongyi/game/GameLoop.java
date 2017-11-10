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
    
    private Grid grid;
    private Painter painter;

    private final int frameRate;
    private final long interval;
    
    private boolean running;
    private boolean pause;

    public GameLoop(Grid grid, GraphicsContext context) {
        this.grid = grid;
        painter = new Painter(grid, context);
        
        frameRate = 50;
        interval = 1000 / frameRate;
        
        running = true;
        pause = false;
    }

    @Override
    public void run() {
        while (running && !pause) {
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
    }

}

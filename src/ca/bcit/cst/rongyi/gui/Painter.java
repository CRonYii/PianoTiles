package ca.bcit.cst.rongyi.gui;

import ca.bcit.cst.rongyi.game.GameLoop;
import ca.bcit.cst.rongyi.game.Grid;
import ca.bcit.cst.rongyi.game.Tile;
import ca.bcit.cst.rongyi.game.TileList;
import javafx.scene.canvas.GraphicsContext;

/**
 * Painter
 *
 * @author Rongyi Chen
 * @version 2017
 */
public class Painter {

    private Grid grid;
    private GraphicsContext context;

    public Painter(Grid grid, GraphicsContext context) {
        super();
        this.grid = grid;
        this.context = context;
    }

    public void paint() {
        paintBackground();
        paintTiles();
    }

    private void paintBackground() {
        context.setFill(grid.BACKGROUND_COLOR);
        context.fillRect(0, 0, grid.getWidth(), grid.getHeight());

        context.setFill(grid.LINE_COLOR);
        for (int i = 1; i < GameLoop.KEYS; i++) {
            context.fillRect(i * grid.getSIZE_WIDTH(), 0, 2, grid.getHeight());
        }
    }

    private void paintTileList(TileList list) {
        context.setFill(list.tileColor);
        for (Tile t : list) {
            context.fillRect(
                    t.getColumn() * grid.getSIZE_WIDTH(),
                    t.getY() - grid.getSZIE_HEIGHT(),
                    grid.getSIZE_WIDTH(),
                    grid.getSZIE_HEIGHT());
        }
    }

    private void paintTiles() {
        for (TileList list : grid.getTileGrid().getTilesList()) {
            paintTileList(list);
        }
    }

}

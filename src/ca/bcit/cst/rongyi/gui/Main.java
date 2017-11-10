package ca.bcit.cst.rongyi.gui;

import java.util.List;

import ca.bcit.cst.rongyi.game.GameLoop;
import ca.bcit.cst.rongyi.game.Grid;
import ca.bcit.cst.rongyi.game.Tile;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Main
 *
 * @author Rongyi Chen
 * @version 2017
 */
public class Main extends Application {

    private static final double SCALE = 2.25;
    private static final int WIDTH = (int) (900.0 / SCALE);
    private static final int HEIGHT = (int) (1600.0 / SCALE);

    private GameLoop loop;
    private Grid grid;
    private GraphicsContext context;

    /**
     * @see javafx.application.Application#start(javafx.stage.Stage)
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();

        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        context = canvas.getGraphicsContext2D();
        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(e -> {
            List<Tile>[] lists = grid.getTileLists();
            switch (e.getCode()) {
            case S:
                if (lists[0].size() != 0) {
                    lists[0].remove(0);
                }
                break;
            case D:
                if (lists[1].size() != 0) {
                    lists[1].remove(0);
                }
                break;
            case K:
                if (lists[2].size() != 0) {
                    lists[2].remove(0);
                }
                break;
            case L:
                if (lists[3].size() != 0) {
                    lists[3].remove(0);
                }
                break;
            default:
                break;
            }
        });

        root.getChildren().add(canvas);

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Piano Tiles");
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.show();

        initialize();

        (new Thread(loop)).start();
    }

    private void initialize() {
        grid = new Grid(WIDTH, HEIGHT);
        loop = new GameLoop(grid, context);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}

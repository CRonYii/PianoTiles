package ca.bcit.cst.rongyi.gui;

import ca.bcit.cst.rongyi.game.GameLoop;
import ca.bcit.cst.rongyi.game.Grid;
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
            switch (e.getCode()) {
            case S:
                grid.removeTile(0);
                break;
            case D:
                grid.removeTile(1);
                break;
            case K:
                grid.removeTile(2);
                break;
            case L:
                grid.removeTile(3);
                break;
            case P:
                loop.togglePause();
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
    }

    private void initialize() {
        grid = new Grid(WIDTH, HEIGHT);
        loop = new GameLoop(grid, context);
        (new Thread(loop, "GameLoop")).start();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}

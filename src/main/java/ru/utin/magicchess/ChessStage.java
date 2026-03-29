package ru.utin.magicchess;

import javafx.scene.Scene;
import javafx.stage.Stage;


public class ChessStage {
    private static ChessStage instance;
    private final Stage stage;

    private ChessStage(Stage primaryStage) {
        stage = primaryStage;
        stage.setTitle("Magic Chess");
        stage.setMaximized(true);
        stage.show();
    }

    public void uploadScene(Scene scene) {
        stage.setScene(scene);
    }


    public static ChessStage getInstance() {
        if (instance == null) {
            synchronized (ChessStage.class) {
                if (instance == null) {
                    throw new IllegalStateException("ChessStage not initialized. Call ChessStage.init(Stage) first.");
                }
            }
        }
        return instance;
    }

    public static void init(Stage stage) {
        if (instance == null) {
            synchronized (ChessStage.class) {
                if (instance == null) {
                    instance = new ChessStage(stage);
                }
            }
        }
    }
}

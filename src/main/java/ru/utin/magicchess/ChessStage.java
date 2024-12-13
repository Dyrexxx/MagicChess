package ru.utin.magicchess;

import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;


public class ChessStage {
    private static ChessStage instance;
    private final Stage stage;

    private ChessStage() {
        stage = new Stage();
        stage.setTitle("Magic Chess");
        stage.setWidth(1300);
        stage.setHeight(800);
        stage.show();
    }

    public void uploadScene(Scene scene) {
        stage.setScene(scene);
    }


    public static ChessStage getInstance() {
        if (instance == null) {
            synchronized (ChessStage.class) {
                if (instance == null) {
                    instance = new ChessStage();
                }
            }
        }
        return instance;
    }
}

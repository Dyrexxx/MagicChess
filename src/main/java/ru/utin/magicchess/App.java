package ru.utin.magicchess;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.utin.magicchess.utils.StageUtil;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        ChessStage chessStage = ChessStage.getInstance();

        chessStage.uploadScene(StageUtil.createScene("menu.fxml"));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
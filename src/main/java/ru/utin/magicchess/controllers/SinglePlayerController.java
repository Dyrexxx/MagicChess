package ru.utin.magicchess.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;
import ru.utin.magicchess.game.GameField;

import java.net.URL;
import java.util.ResourceBundle;

public class SinglePlayerController implements Initializable {
    @FXML
    private FlowPane gameContent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GameField gameField = GameField.getInstance();
        gameContent.getChildren().add(gameField.getCanvas());
        gameField.paint();
    }
}

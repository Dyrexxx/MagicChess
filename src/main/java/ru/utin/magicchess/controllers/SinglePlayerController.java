package ru.utin.magicchess.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import ru.utin.magicchess.game.BaseGameField;
import ru.utin.magicchess.game.Game;

import java.net.URL;
import java.util.ResourceBundle;

public class SinglePlayerController implements Initializable {
    @FXML
    private VBox gameContent;
    @FXML
    private Label moved;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Game game = new Game();
        gameContent.getChildren().add(game.getCanvas());
    }
}

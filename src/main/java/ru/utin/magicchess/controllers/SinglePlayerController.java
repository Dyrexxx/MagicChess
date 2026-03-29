package ru.utin.magicchess.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import ru.utin.magicchess.app.CurrentGameHolder;
import ru.utin.magicchess.audio.AudioService;
import ru.utin.magicchess.domain.game.GameSession;
import ru.utin.magicchess.domain.game.GameSettings;
import ru.utin.magicchess.ui.game.SinglePlayerGamePresenter;

import java.net.URL;
import java.util.ResourceBundle;

public class SinglePlayerController implements Initializable {
    @FXML
    private VBox gameContent;
    @FXML
    private Label moved;
    private final CurrentGameHolder currentGameHolder;
    private final AudioService audioService;

    public SinglePlayerController(CurrentGameHolder currentGameHolder, AudioService audioService) {
        this.currentGameHolder = currentGameHolder;
        this.audioService = audioService;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GameSession session = currentGameHolder.currentSession()
                .orElseGet(() -> GameSession.create(GameSettings.defaultSettings()));
        currentGameHolder.setSession(session);

        SinglePlayerGamePresenter presenter = new SinglePlayerGamePresenter(session, audioService);
        presenter.bind(moved);
        gameContent.getChildren().setAll(presenter.canvas());
        VBox.setVgrow(presenter.canvas(), Priority.ALWAYS);
    }
}

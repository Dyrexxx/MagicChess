package ru.utin.magicchess.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ru.utin.magicchess.ChessStage;
import ru.utin.magicchess.models.MusicPlayer;
import ru.utin.magicchess.utils.StageUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    public MenuController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.play();
    }

    @FXML
    protected void onSinglePlayer() {
        ChessStage.getInstance().uploadScene(StageUtil.createScene("setting_singleplay.fxml"));
    }
}
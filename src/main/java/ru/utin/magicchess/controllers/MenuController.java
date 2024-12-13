package ru.utin.magicchess.controllers;

import javafx.fxml.FXML;
import ru.utin.magicchess.ChessStage;
import ru.utin.magicchess.models.MusicPlayer;
import ru.utin.magicchess.utils.StageUtil;

public class MenuController {
    public MenuController() {
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.play();

    }

    @FXML
    protected void onSinglePlayer() {
        ChessStage.getInstance().uploadScene(StageUtil.createScene("setting_singleplay.fxml"));
    }
}
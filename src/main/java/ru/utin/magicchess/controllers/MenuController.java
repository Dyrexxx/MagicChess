package ru.utin.magicchess.controllers;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import ru.utin.magicchess.ChessStage;
import ru.utin.magicchess.models.MusicPlayer;
import ru.utin.magicchess.utils.StageUtil;

import java.awt.*;

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
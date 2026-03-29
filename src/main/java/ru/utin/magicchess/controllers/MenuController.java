package ru.utin.magicchess.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ru.utin.magicchess.ChessStage;
import ru.utin.magicchess.audio.AudioService;
import ru.utin.magicchess.audio.SoundType;
import ru.utin.magicchess.utils.StageUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AudioService.getInstance().playBgm(SoundType.MENU_MUSIC);
    }

    @FXML
    protected void onSinglePlayer() {
        ChessStage.getInstance().uploadScene(StageUtil.createScene("setting_singleplay.fxml"));
    }
}

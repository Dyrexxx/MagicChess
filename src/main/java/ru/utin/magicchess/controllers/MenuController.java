package ru.utin.magicchess.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ru.utin.magicchess.app.SceneNavigator;
import ru.utin.magicchess.app.Screen;
import ru.utin.magicchess.audio.AudioService;
import ru.utin.magicchess.audio.SoundType;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    private final SceneNavigator sceneNavigator;
    private final AudioService audioService;

    public MenuController(SceneNavigator sceneNavigator, AudioService audioService) {
        this.sceneNavigator = sceneNavigator;
        this.audioService = audioService;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        audioService.playBgm(SoundType.MENU_MUSIC);
    }

    @FXML
    protected void onSinglePlayer() {
        sceneNavigator.navigateTo(Screen.SETTING_SINGLEPLAY);
    }
}

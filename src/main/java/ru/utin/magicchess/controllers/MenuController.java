package ru.utin.magicchess.controllers;

import javafx.fxml.FXML;
import ru.utin.magicchess.ChessStage;
import ru.utin.magicchess.utils.StageUtil;

public class MenuController {
    @FXML
    protected void onSinglePlayer() {
        ChessStage.getInstance().uploadScene(StageUtil.createScene("single_player.fxml"));
    }
}
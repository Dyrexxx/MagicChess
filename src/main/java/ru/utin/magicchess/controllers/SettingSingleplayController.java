package ru.utin.magicchess.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import ru.utin.magicchess.ChessStage;
import ru.utin.magicchess.game.SettingFieldGame;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.game.factory.TypeFigure;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;
import ru.utin.magicchess.utils.StageUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingSingleplayController implements Initializable {
    @FXML
    private FlowPane rootPane;
    @FXML
    private VBox speciesPane;
    @FXML
    private ChoiceBox<TypeColorFigure> sideBox;
    @FXML
    private CheckBox baseGameCheckBox;
    @FXML
    private ChoiceBox<TypeChessFigure> speciesOpponent;
    @FXML
    private ChoiceBox<TypeChessFigure> mySpecies;
    @FXML
    private ImageView mySpeciesImage;
    @FXML
    private ImageView opponentSpeciesImage;
    @FXML
    private Label error;

    @FXML
    private void onStart() {
        try {
            if (!baseGameCheckBox.isSelected() && (
                    speciesOpponent.getValue() == TypeChessFigure.NONE || mySpecies.getValue() == TypeChessFigure.NONE)) {
                throw new NullPointerException("Раса не выбрана");
            }
            else {
                SettingFieldGame settingFieldGame = SettingFieldGame.getInstance();
                settingFieldGame.setMyColorSide(sideBox.getValue());
                settingFieldGame.setOpponentColorSide(sideBox.getValue() == TypeColorFigure.BLACK ? TypeColorFigure.WHITE : TypeColorFigure.BLACK);
                settingFieldGame.setTypeFigure(baseGameCheckBox.isSelected() ? TypeFigure.BASE : TypeFigure.SPECIES);
                settingFieldGame.setSpeciesOpponent(speciesOpponent.getValue());
                settingFieldGame.setMySpecies(mySpecies.getValue());
                ChessStage.getInstance().uploadScene(StageUtil.createScene("single_player.fxml"));
            }
        } catch (NullPointerException e) {
            error.setText(e.getMessage());
        }
    }

    @FXML
    private void onBaseGameCheckBox() {
        if (baseGameCheckBox.isSelected()) {
            speciesPane.setVisible(false);
            speciesOpponent.setValue(TypeChessFigure.NONE);
            mySpecies.setValue(TypeChessFigure.NONE);
        } else {
            speciesPane.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mySpeciesImage.setImage(new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\species\\elf.jpg"));
        //
        sideBox.setValue(TypeColorFigure.WHITE);
        sideBox.getItems().add(TypeColorFigure.WHITE);
        sideBox.getItems().add(TypeColorFigure.BLACK);
        //
        speciesOpponent.setValue(TypeChessFigure.NONE);
        speciesOpponent.getItems().add(TypeChessFigure.ELF);
//
        mySpecies.setValue(TypeChessFigure.NONE);
        mySpecies.getItems().add(TypeChessFigure.ELF);

    }
}

package ru.utin.magicchess.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import ru.utin.magicchess.ChessStage;
import ru.utin.magicchess.game.SettingFieldGame;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;
import ru.utin.magicchess.utils.ResourceUtil;
import ru.utin.magicchess.utils.StageUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingSingleplayController implements Initializable {
    @FXML private FlowPane rootPane;
    @FXML private VBox speciesPane;
    @FXML private ChoiceBox<TypeColorFigure> sideBox;
    @FXML private CheckBox baseGameCheckBox;
    @FXML private ChoiceBox<TypeChessFigure> speciesOpponent;
    @FXML private ChoiceBox<TypeChessFigure> mySpecies;
    @FXML private ImageView mySpeciesImage;
    @FXML private ImageView opponentSpeciesImage;
    @FXML private Label error;

    @FXML
    private void onStart() {
        if (!baseGameCheckBox.isSelected() &&
                (speciesOpponent.getValue() == TypeChessFigure.NONE || mySpecies.getValue() == TypeChessFigure.NONE)) {
            error.setText("Раса не выбрана");
            return;
        }

        SettingFieldGame settings = SettingFieldGame.getInstance();
        TypeColorFigure myColor = sideBox.getValue();
        TypeColorFigure opponentColor = myColor == TypeColorFigure.BLACK ? TypeColorFigure.WHITE : TypeColorFigure.BLACK;

        settings.setMyColorSide(myColor);
        settings.setOpponentColorSide(opponentColor);

        if (baseGameCheckBox.isSelected()) {
            settings.setMySpecies(TypeChessFigure.CLASSIC);
            settings.setOpponentSpecies(TypeChessFigure.CLASSIC);
        } else {
            settings.setMySpecies(mySpecies.getValue());
            settings.setOpponentSpecies(speciesOpponent.getValue());
        }

        ChessStage.getInstance().uploadScene(StageUtil.createScene("single_player.fxml"));
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
        mySpeciesImage.setImage(new Image(ResourceUtil.resourceUrl("/ru/utin/magicchess/images/species/elf.jpg")));

        sideBox.getItems().addAll(TypeColorFigure.WHITE, TypeColorFigure.BLACK);
        sideBox.setValue(TypeColorFigure.WHITE);

        speciesOpponent.getItems().add(TypeChessFigure.ELF);
        speciesOpponent.setValue(TypeChessFigure.NONE);

        mySpecies.getItems().add(TypeChessFigure.ELF);
        mySpecies.setValue(TypeChessFigure.NONE);
    }
}

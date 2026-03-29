package ru.utin.magicchess.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import ru.utin.magicchess.app.GameStarter;
import ru.utin.magicchess.domain.game.GameSettings;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;
import ru.utin.magicchess.utils.ResourceUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingSingleplayController implements Initializable {
    @FXML private VBox speciesPane;
    @FXML private ChoiceBox<TypeColorFigure> sideBox;
    @FXML private CheckBox baseGameCheckBox;
    @FXML private ChoiceBox<TypeChessFigure> speciesOpponent;
    @FXML private ChoiceBox<TypeChessFigure> mySpecies;
    @FXML private ImageView mySpeciesImage;
    @FXML private ImageView opponentSpeciesImage;
    @FXML private Label error;
    private final GameStarter gameStarter;

    public SettingSingleplayController(GameStarter gameStarter) {
        this.gameStarter = gameStarter;
    }

    @FXML
    private void onStart() {
        TypeColorFigure myColor = sideBox.getValue();
        if (myColor == null) {
            error.setText("Сторона не выбрана");
            return;
        }

        TypeChessFigure mySelectedSpecies = baseGameCheckBox.isSelected() ? TypeChessFigure.CLASSIC : mySpecies.getValue();
        TypeChessFigure opponentSelectedSpecies = baseGameCheckBox.isSelected() ? TypeChessFigure.CLASSIC : speciesOpponent.getValue();
        if (mySelectedSpecies == null || opponentSelectedSpecies == null
                || mySelectedSpecies == TypeChessFigure.NONE || opponentSelectedSpecies == TypeChessFigure.NONE) {
            error.setText("Раса не выбрана");
            return;
        }

        error.setText("");
        TypeColorFigure opponentColor = myColor == TypeColorFigure.BLACK ? TypeColorFigure.WHITE : TypeColorFigure.BLACK;
        gameStarter.startSinglePlayer(new GameSettings(myColor, opponentColor, mySelectedSpecies, opponentSelectedSpecies));
    }

    @FXML
    private void onBaseGameCheckBox() {
        boolean baseGame = baseGameCheckBox.isSelected();
        speciesPane.setVisible(!baseGame);
        speciesPane.setManaged(!baseGame);
        if (baseGame) {
            mySpecies.setValue(TypeChessFigure.CLASSIC);
            speciesOpponent.setValue(TypeChessFigure.CLASSIC);
        } else {
            mySpecies.setValue(TypeChessFigure.NONE);
            speciesOpponent.setValue(TypeChessFigure.NONE);
        }
        updateSpeciesPreview();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sideBox.setItems(FXCollections.observableArrayList(TypeColorFigure.values()));
        sideBox.setValue(TypeColorFigure.WHITE);
        mySpecies.setItems(FXCollections.observableArrayList(TypeChessFigure.NONE, TypeChessFigure.CLASSIC, TypeChessFigure.ELF));
        speciesOpponent.setItems(FXCollections.observableArrayList(TypeChessFigure.NONE, TypeChessFigure.CLASSIC, TypeChessFigure.ELF));
        mySpecies.setValue(TypeChessFigure.NONE);
        speciesOpponent.setValue(TypeChessFigure.NONE);
        mySpecies.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> updateSpeciesPreview());
        speciesOpponent.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> updateSpeciesPreview());
        baseGameCheckBox.setSelected(false);
        onBaseGameCheckBox();
    }

    private void updateSpeciesPreview() {
        mySpeciesImage.setImage(resolveSpeciesImage(mySpecies.getValue()));
        opponentSpeciesImage.setImage(resolveSpeciesImage(speciesOpponent.getValue()));
    }

    private Image resolveSpeciesImage(TypeChessFigure species) {
        if (species != TypeChessFigure.ELF) {
            return null;
        }
        return new Image(ResourceUtil.resourceUrl("/ru/utin/magicchess/images/species/elf.jpg"));
    }
}

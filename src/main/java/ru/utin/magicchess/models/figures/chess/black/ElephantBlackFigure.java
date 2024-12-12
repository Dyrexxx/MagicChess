package ru.utin.magicchess.models.figures.chess.black;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.Elephant;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public class ElephantBlackFigure extends Elephant {
    public ElephantBlackFigure() {
        type = TypeChessFigure.BLACK;
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\black\\bElephant.png");
    }
}

package ru.utin.magicchess.models.figures.chess.base.black;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.base.Elephant;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public class BaseElephantBlackFigure extends Elephant {
    public BaseElephantBlackFigure() {
        type = TypeChessFigure.BLACK;
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\black\\bElephant.png");
    }
}

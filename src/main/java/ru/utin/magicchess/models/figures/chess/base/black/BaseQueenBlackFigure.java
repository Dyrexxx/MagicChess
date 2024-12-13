package ru.utin.magicchess.models.figures.chess.base.black;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.base.Queen;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public class BaseQueenBlackFigure extends Queen {
    public BaseQueenBlackFigure() {
        type = TypeChessFigure.BLACK;
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\black\\bQueen.png");
    }
}

package ru.utin.magicchess.models.figures.chess.base.black;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.base.Rook;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public class BaseRookBlackFigure extends Rook {
    public BaseRookBlackFigure() {
        type = TypeChessFigure.BLACK;
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\black\\bRook.png");
    }
}

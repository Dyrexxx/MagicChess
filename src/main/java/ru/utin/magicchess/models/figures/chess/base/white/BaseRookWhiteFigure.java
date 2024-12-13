package ru.utin.magicchess.models.figures.chess.base.white;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.base.Rook;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public class BaseRookWhiteFigure extends Rook {
    public BaseRookWhiteFigure() {
        type = TypeChessFigure.WHITE;
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\white\\wRook.png");
    }
}

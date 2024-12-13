package ru.utin.magicchess.models.figures.chess.base.black;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.base.King;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public class BaseKingBlackFigure extends King {
    public BaseKingBlackFigure() {
        type = TypeChessFigure.BLACK;
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\black\\bKing.png");
    }
}

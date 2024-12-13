package ru.utin.magicchess.models.figures.chess.base.white;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.base.King;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public class BaseKingWhiteFigure extends King {
    public BaseKingWhiteFigure() {
        type = TypeChessFigure.WHITE;
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\white\\wKing.png");
    }
}

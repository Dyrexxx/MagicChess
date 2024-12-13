package ru.utin.magicchess.models.figures.chess.base.white;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.base.Queen;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public class BaseQueenWhiteFigure extends Queen {
    public BaseQueenWhiteFigure() {
        type = TypeChessFigure.WHITE;
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\white\\wQueen.png");
    }
}

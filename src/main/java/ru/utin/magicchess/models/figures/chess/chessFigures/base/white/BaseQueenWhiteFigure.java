package ru.utin.magicchess.models.figures.chess.chessFigures.base.white;

import javafx.scene.image.Image;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.models.figures.chess.abstracts.Queen;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;
import ru.utin.magicchess.models.figures.chess.color.QueenWhite;

public class BaseQueenWhiteFigure extends QueenWhite {
    public BaseQueenWhiteFigure(TypeSide typeSide) {
        super(typeSide);
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\white\\wQueen.png");
    }
}

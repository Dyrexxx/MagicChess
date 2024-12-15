package ru.utin.magicchess.models.figures.chess.chessFigures.base.black;

import javafx.scene.image.Image;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.Queen;
import ru.utin.magicchess.models.figures.chess.color.QueenBlack;

public class BaseQueenBlackFigure extends QueenBlack {
    public BaseQueenBlackFigure(TypeSide typeSide) {
        super(typeSide);
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\black\\bQueen.png");
    }
}

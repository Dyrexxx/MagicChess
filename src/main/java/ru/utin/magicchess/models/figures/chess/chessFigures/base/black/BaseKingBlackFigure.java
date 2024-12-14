package ru.utin.magicchess.models.figures.chess.chessFigures.base.black;

import javafx.scene.image.Image;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.King;
import ru.utin.magicchess.models.figures.chess.color.KingBlack;

public class BaseKingBlackFigure extends KingBlack {
    public BaseKingBlackFigure() {
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\black\\bKing.png");
    }
}

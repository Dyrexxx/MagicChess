package ru.utin.magicchess.models.figures.chess.chessFigures.base.white;

import javafx.scene.image.Image;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.King;
import ru.utin.magicchess.models.figures.chess.color.KingWhite;

public class BaseKingWhiteFigure extends KingWhite {
    public BaseKingWhiteFigure() {
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\white\\wKing.png");
    }
}
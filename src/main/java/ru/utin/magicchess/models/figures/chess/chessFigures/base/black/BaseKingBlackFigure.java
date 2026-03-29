package ru.utin.magicchess.models.figures.chess.chessFigures.base.black;

import javafx.scene.image.Image;
import ru.utin.magicchess.App;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.models.figures.chess.color.KingBlack;

public class BaseKingBlackFigure extends KingBlack {

    public BaseKingBlackFigure(TypeSide typeSide) {
        super(typeSide);
        image = new Image(App.class.getResource("/ru/utin/magicchess/images/chess/black/bKing.png").toExternalForm());
    }

}

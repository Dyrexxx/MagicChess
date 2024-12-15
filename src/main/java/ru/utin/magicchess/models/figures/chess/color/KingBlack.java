package ru.utin.magicchess.models.figures.chess.color;

import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.King;

public class KingBlack extends King {
    {
        type = TypeColorFigure.BLACK;
    }

    public KingBlack(TypeSide typeSide) {
        super(typeSide);
    }
}

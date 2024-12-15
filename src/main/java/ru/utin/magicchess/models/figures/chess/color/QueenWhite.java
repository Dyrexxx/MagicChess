package ru.utin.magicchess.models.figures.chess.color;

import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.Queen;

public class QueenWhite extends Queen {
    {
        type = TypeColorFigure.WHITE;
    }

    public QueenWhite(TypeSide typeSide) {
        super(typeSide);
    }
}

package ru.utin.magicchess.models.figures.chess.color;

import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.Queen;

public class QueenBlack extends Queen {
    {
        type = TypeColorFigure.BLACK;
    }

    public QueenBlack(TypeSide typeSide) {
        super(typeSide);
    }
}

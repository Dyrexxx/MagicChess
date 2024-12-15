package ru.utin.magicchess.models.figures.chess.color;

import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.Rook;

public class RookWhite extends Rook {
    {
        type = TypeColorFigure.WHITE;
    }

    public RookWhite(TypeSide typeSide) {
        super(typeSide);
    }
}

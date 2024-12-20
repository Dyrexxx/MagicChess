package ru.utin.magicchess.models.figures.chess.color;

import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.Pawn;

public class PawnBlack extends Pawn {
    {
        type = TypeColorFigure.BLACK;
    }

    public PawnBlack(TypeSide typeSide) {
        super(typeSide);
    }
}

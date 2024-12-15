package ru.utin.magicchess.models.figures.chess.color;

import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.Elephant;

public abstract class ElephantBlack extends Elephant {
    {
        type = TypeColorFigure.BLACK;
    }

    public ElephantBlack(TypeSide typeSide) {
        super(typeSide);
    }
}

package ru.utin.magicchess.models.figures.chess.color;

import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.Elephant;

public class ElephantWhite extends Elephant {
    {
        type = TypeColorFigure.WHITE;
    }

    public ElephantWhite(TypeSide typeSide) {
        super(typeSide);
    }
}

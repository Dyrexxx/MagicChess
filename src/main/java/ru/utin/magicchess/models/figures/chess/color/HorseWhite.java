package ru.utin.magicchess.models.figures.chess.color;

import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.Horse;

public class HorseWhite extends Horse {
    {
        type = TypeColorFigure.WHITE;
    }

    public HorseWhite(TypeSide typeSide) {
        super(typeSide);
    }
}

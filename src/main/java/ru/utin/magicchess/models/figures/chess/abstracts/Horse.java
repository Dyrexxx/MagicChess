package ru.utin.magicchess.models.figures.chess.abstracts;

import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.models.figures.chess.ChessFigure;


public abstract class Horse extends ChessFigure {
    public Horse(TypeSide typeSide) {
        super(typeSide);
    }

    @Override
    protected void activate(int i, int j) {

        for (int x = 1, y = 2; x <= 2; x++, y--) {
            run(i + x, j + y);
            run(i + x, j - y);
            run(i - x, j + y);
            run(i - x, j - y);
        }
    }
}

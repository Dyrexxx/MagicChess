package ru.utin.magicchess.models.figures.chess.abstracts;

import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.ChessFigure;


public abstract class Horse extends ChessFigure {
    public Horse(TypeSide typeSide) {
        super(typeSide);
    }

    @Override
    protected void activated(int i, int j, Cell[][] field) {
        for (int x = 1, y = 2; x <= 2; x++, y--) {
            run(i + x, j + y, field);
            run(i + x, j - y, field);
            run(i - x, j + y, field);
            run(i - x, j - y, field);
        }
    }
}

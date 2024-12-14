package ru.utin.magicchess.models.figures.chess.base;

import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.ChessFigure;


public abstract class Horse extends ChessFigure {
    @Override
    protected void activate(int i, int j, Cell[][] fieldCopy) {
        super.activate(i, j, fieldCopy);
        for (int x = 1, y = 2; x <= 2; x++, y--) {
            run(i + x, j + y);
            run(i + x, j - y);
            run(i - x, j + y);
            run(i - x, j - y);
        }
    }
}

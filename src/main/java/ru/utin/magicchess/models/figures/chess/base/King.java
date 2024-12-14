package ru.utin.magicchess.models.figures.chess.base;

import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.ChessFigure;

public class King extends ChessFigure {
    @Override
    protected void activate(int i, int j, Cell[][] fieldCopy) {
        super.activate(i, j, fieldCopy);
        run(i - 1, j);
        run(i + 1, j);
        run(i, j + 1);
        run(i, j - 1);
        run(i + 1, j - 1);
        run(i + 1, j + 1);
        run(i - 1, j + 1);
        run(i - 1, j - 1);


    }
}

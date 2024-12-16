package ru.utin.magicchess.models.figures.chess.abstracts;

import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.ChessFigure;

public class King extends ChessFigure {
    public King(TypeSide typeSide) {
        super(typeSide);
    }

    @Override
    protected void activated(int i, int j, Cell[][] field) {

        run(i - 1, j, field);
        run(i + 1, j, field);
        run(i, j + 1, field);
        run(i, j - 1, field);
        run(i + 1, j - 1, field);
        run(i + 1, j + 1, field);
        run(i - 1, j + 1, field);
        run(i - 1, j - 1, field);

    }

}

package ru.utin.magicchess.models.figures.chess.abstracts;

import ru.utin.magicchess.models.figures.chess.ChessFigure;

public class King extends ChessFigure {
    @Override
    protected void activate(int i, int j) {

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
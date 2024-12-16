package ru.utin.magicchess.models.figures.chess.abstracts;

import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.ChessFigure;
import ru.utin.magicchess.models.figures.chess.RunType;

public class Rook extends ChessFigure {
    public Rook(TypeSide typeSide) {
        super(typeSide);
    }

    @Override
    protected void activated(int i, int j, Cell[][] field) {

        RunType left = RunType.NONE;
        RunType right = RunType.NONE;
        RunType up = RunType.NONE;
        RunType down = RunType.NONE;
        for (int x = 1; x <= 8; x++) {
            if (up != RunType.STOP) {
                RunType runType = run(i - x, j, field);
                up = runType == RunType.ATTACK ? RunType.STOP : runType;
            }
            if (down != RunType.STOP) {
                RunType runType = run(i + x, j, field);
                down = runType == RunType.ATTACK ? RunType.STOP : runType;
            }
            if (left != RunType.STOP) {
                RunType runType = run(i, j - x, field);
                left = runType == RunType.ATTACK ? RunType.STOP : runType;
            }
            if (right != RunType.STOP) {
                RunType runType = run(i, j + x, field);
                right = runType == RunType.ATTACK ? RunType.STOP : runType;
            }
        }
    }
}
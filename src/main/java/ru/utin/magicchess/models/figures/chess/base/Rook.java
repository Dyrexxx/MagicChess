package ru.utin.magicchess.models.figures.chess.base;

import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.ChessFigure;
import ru.utin.magicchess.models.figures.chess.RunType;

public class Rook extends ChessFigure {
    @Override
    protected void activate(int i, int j, Cell[][] fieldCopy) {
        super.activate(i, j, fieldCopy);
        RunType left = RunType.NONE;
        RunType right = RunType.NONE;
        RunType up = RunType.NONE;
        RunType down = RunType.NONE;
        for (int x = 1; x <= 8; x++) {
            if (up != RunType.STOP) {
                RunType runType = run(i - x, j);
                up = runType == RunType.ATTACK ? RunType.STOP : runType;
            }
            if (down != RunType.STOP) {
                RunType runType = run(i + x, j);
                down = runType == RunType.ATTACK ? RunType.STOP : runType;
            }
            if (left != RunType.STOP) {
                RunType runType = run(i, j - x);
                left = runType == RunType.ATTACK ? RunType.STOP : runType;
            }
            if (right != RunType.STOP) {
                RunType runType = run(i, j + x);
                right = runType == RunType.ATTACK ? RunType.STOP : runType;
            }
        }
    }
}
package ru.utin.magicchess.models.figures.chess.abstracts;

import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.ChessFigure;
import ru.utin.magicchess.models.figures.chess.RunType;

public class Queen extends ChessFigure {
    public Queen(TypeSide typeSide) {
        super(typeSide);
    }

    @Override
   protected void activated(int i, int j, Cell[][] field) {
        RunType leftUp = RunType.NONE;
        RunType leftDown = RunType.NONE;
        RunType rightUp = RunType.NONE;
        RunType rightDown = RunType.NONE;
        RunType left = RunType.NONE;
        RunType right = RunType.NONE;
        RunType up = RunType.NONE;
        RunType down = RunType.NONE;
        for (int x = 1; x <= 8; x++) {
            if (leftUp != RunType.STOP) {
                RunType runType = run(i - x, j - x, field);
                leftUp = runType == RunType.ATTACK ? RunType.STOP : runType;
            }
            if (rightUp != RunType.STOP) {
                RunType runType = run(i - x, j + x, field);
                rightUp = runType == RunType.ATTACK ? RunType.STOP : runType;
            }
            if (leftDown != RunType.STOP) {
                RunType runType = run(i + x, j - x, field);
                leftDown = runType == RunType.ATTACK ? RunType.STOP : runType;
            }
            if (rightDown != RunType.STOP) {
                RunType runType = run(i + x, j + x, field);
                rightDown = runType == RunType.ATTACK ? RunType.STOP : runType;
            }
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
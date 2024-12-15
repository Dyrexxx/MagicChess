package ru.utin.magicchess.models.figures.chess.abstracts;

import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.models.figures.chess.ChessFigure;
import ru.utin.magicchess.models.figures.chess.RunType;

public class Queen extends ChessFigure {
    public Queen(TypeSide typeSide) {
        super(typeSide);
    }

    @Override
    protected void activate(int i, int j) {
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
                RunType runType = run(i - x, j - x);
                leftUp = runType == RunType.ATTACK ? RunType.STOP : runType;
            }
            if (rightUp != RunType.STOP) {
                RunType runType = run(i - x, j + x);
                rightUp = runType == RunType.ATTACK ? RunType.STOP : runType;
            }
            if (leftDown != RunType.STOP) {
                RunType runType = run(i + x, j - x);
                leftDown = runType == RunType.ATTACK ? RunType.STOP : runType;
            }
            if (rightDown != RunType.STOP) {
                RunType runType = run(i + x, j + x);
                rightDown = runType == RunType.ATTACK ? RunType.STOP : runType;
            }
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
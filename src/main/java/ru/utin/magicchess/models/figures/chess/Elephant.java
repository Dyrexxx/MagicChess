package ru.utin.magicchess.models.figures.chess;

public abstract class Elephant extends ChessFigure {
    @Override
    protected void activate(int i, int j) {
        super.activate(i, j);
        RunType leftUp = RunType.NONE;
        RunType leftDown = RunType.NONE;
        RunType rightUp = RunType.NONE;
        RunType rightDown = RunType.NONE;
        for (int x = 1; x <= 8; x++) {
            if (leftUp != RunType.STOP) {
                leftUp = run(i - x, j - x) == RunType.ATTACK ? RunType.STOP : RunType.NONE;
            }
            if (rightUp != RunType.STOP) {
                rightUp = run(i - x, j + x) == RunType.ATTACK ? RunType.STOP : RunType.NONE;
            }
            if (leftDown != RunType.STOP) {
                leftDown = run(i + x, j - x) == RunType.ATTACK ? RunType.STOP : RunType.NONE;
            }
            if (rightDown != RunType.STOP) {
                rightDown = run(i + x, j + x) == RunType.ATTACK ? RunType.STOP : RunType.NONE;
            }
        }
    }
}

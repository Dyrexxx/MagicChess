package ru.utin.magicchess.models.figures.chess.abstracts;

import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.models.cells.ResultActiveFigureModel;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.ChessFigure;
import ru.utin.magicchess.models.figures.chess.RunType;

public abstract class Elephant extends ChessFigure {
    public Elephant(TypeSide typeSide) {
        super(typeSide);
    }

    @Override
    protected ResultActiveFigureModel activated(int i, int j, Cell[][] field) {
        RunType leftUp = RunType.NONE;
        RunType leftDown = RunType.NONE;
        RunType rightUp = RunType.NONE;
        RunType rightDown = RunType.NONE;
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
        }
        return super.sendActivatedModel();
    }
}

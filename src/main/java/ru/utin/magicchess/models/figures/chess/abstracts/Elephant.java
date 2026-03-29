package ru.utin.magicchess.models.figures.chess.abstracts;

import javafx.scene.image.Image;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.cells.ResultActiveFigureModel;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.ChessFigure;
import ru.utin.magicchess.models.figures.chess.RunType;

public class Elephant extends ChessFigure {

    public Elephant(TypeSide typeSide, TypeColorFigure color, Image image) {
        super(typeSide, color);
        this.image = image;
    }

    @Override
    protected ResultActiveFigureModel activated(int i, int j, Cell[][] field) {
        ResultActiveFigureModel model = new ResultActiveFigureModel();
        RunType leftUp = RunType.NONE, leftDown = RunType.NONE;
        RunType rightUp = RunType.NONE, rightDown = RunType.NONE;

        for (int x = 1; x <= 8; x++) {
            if (leftUp != RunType.STOP) {
                RunType rt = run(i - x, j - x, field, model);
                leftUp = rt == RunType.ATTACK ? RunType.STOP : rt;
            }
            if (rightUp != RunType.STOP) {
                RunType rt = run(i - x, j + x, field, model);
                rightUp = rt == RunType.ATTACK ? RunType.STOP : rt;
            }
            if (leftDown != RunType.STOP) {
                RunType rt = run(i + x, j - x, field, model);
                leftDown = rt == RunType.ATTACK ? RunType.STOP : rt;
            }
            if (rightDown != RunType.STOP) {
                RunType rt = run(i + x, j + x, field, model);
                rightDown = rt == RunType.ATTACK ? RunType.STOP : rt;
            }
        }
        return model;
    }
}

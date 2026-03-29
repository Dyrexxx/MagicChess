package ru.utin.magicchess.models.figures.chess.abstracts;

import javafx.scene.image.Image;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.cells.ResultActiveFigureModel;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.ChessFigure;
import ru.utin.magicchess.models.figures.chess.RunType;

public class Rook extends ChessFigure {

    public Rook(TypeSide typeSide, TypeColorFigure color, Image image) {
        super(typeSide, color);
        this.image = image;
    }

    @Override
    protected ResultActiveFigureModel activated(int i, int j, Cell[][] field) {
        ResultActiveFigureModel model = new ResultActiveFigureModel();
        RunType left = RunType.NONE, right = RunType.NONE;
        RunType up = RunType.NONE, down = RunType.NONE;

        for (int x = 1; x <= 8; x++) {
            if (up != RunType.STOP) {
                RunType rt = run(i - x, j, field, model);
                up = rt == RunType.ATTACK ? RunType.STOP : rt;
            }
            if (down != RunType.STOP) {
                RunType rt = run(i + x, j, field, model);
                down = rt == RunType.ATTACK ? RunType.STOP : rt;
            }
            if (left != RunType.STOP) {
                RunType rt = run(i, j - x, field, model);
                left = rt == RunType.ATTACK ? RunType.STOP : rt;
            }
            if (right != RunType.STOP) {
                RunType rt = run(i, j + x, field, model);
                right = rt == RunType.ATTACK ? RunType.STOP : rt;
            }
        }
        return model;
    }
}

package ru.utin.magicchess.models.figures.chess.abstracts;

import javafx.scene.image.Image;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.cells.ResultActiveFigureModel;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.ChessFigure;

public class Horse extends ChessFigure {

    public Horse(TypeSide typeSide, TypeColorFigure color, Image image) {
        super(typeSide, color);
        this.image = image;
    }

    @Override
    protected ResultActiveFigureModel activated(int i, int j, Cell[][] field) {
        ResultActiveFigureModel model = new ResultActiveFigureModel();
        for (int x = 1, y = 2; x <= 2; x++, y--) {
            run(i + x, j + y, field, model);
            run(i + x, j - y, field, model);
            run(i - x, j + y, field, model);
            run(i - x, j - y, field, model);
        }
        return model;
    }
}

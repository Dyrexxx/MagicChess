package ru.utin.magicchess.models.figures.chess;

import javafx.scene.canvas.GraphicsContext;
import ru.utin.magicchess.models.cells.ResultActiveFigureModel;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.Figure;

public class NoFigure extends Figure {


    public NoFigure() {
        super(null);
    }


    @Override
    protected ResultActiveFigureModel activated(int i, int j, Cell[][] field) {
        return null;
    }

    @Override
    protected void drawImage(GraphicsContext gc, int x, int y, int size) {

    }
}

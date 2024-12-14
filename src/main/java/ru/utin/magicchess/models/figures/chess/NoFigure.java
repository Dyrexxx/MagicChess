package ru.utin.magicchess.models.figures.chess;

import javafx.scene.canvas.GraphicsContext;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.Figure;

import java.util.List;

public class NoFigure extends Figure {



    @Override
    protected void activate(int i, int j, Cell[][] field) {

    }

    @Override
    protected void drawImage(GraphicsContext gc, int x, int y, int size) {

    }
}

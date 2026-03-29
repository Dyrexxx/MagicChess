package ru.utin.magicchess.models.cells;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.NoFigure;

public class BaseChessCell extends Cell {
    private final Color cellColor;

    public BaseChessCell(int x, int y, int size, Color cellColor) {
        super(x, y, size);
        this.cellColor = cellColor;
        this.figure = new NoFigure();
    }

    @Override
    protected void draw(GraphicsContext gc) {
        gc.setFill(cellColor);
        gc.fillRect(x, y, size, size);
        figure.draw(gc, x, y, size);
    }
}

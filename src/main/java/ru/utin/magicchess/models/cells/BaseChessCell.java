package ru.utin.magicchess.models.cells;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.NoFigure;

public class BaseChessCell extends Cell {
    private static Color color = Color.BLACK;
    private final Color cellColor = color;

    public BaseChessCell(int x, int y, int size) {
        super(x, y, size);
        figure = new NoFigure();
    }

    @Override
    protected void draw(GraphicsContext gc) {
        gc.setFill(cellColor);
        gc.fillRect(x, y, size, size);
        figure.draw(gc, x, y, size);
    }

    public static void changeColor() {
        color = color == Color.BLACK ? Color.WHITE : Color.BLACK;
    }

}

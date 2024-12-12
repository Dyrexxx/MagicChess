package ru.utin.magicchess.models.figures.chess;

import javafx.scene.canvas.GraphicsContext;
import ru.utin.magicchess.models.cells.parent.Cell;

import static ru.utin.magicchess.utils.GameUtil.indexIsArray;


public abstract class Horse extends ChessFigure {
    @Override
    protected void activate(int i, int j) {
        super.activate(i, j);
        for (int x = 1, y = 2; x <= 2; x++, y--) {
            run(i + x, j + y);
            run(i + x, j - y);
            run(i - x, j + y);
            run(i - x, j - y);
        }
    }
}

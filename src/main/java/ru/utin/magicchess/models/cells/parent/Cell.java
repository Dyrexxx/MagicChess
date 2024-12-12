package ru.utin.magicchess.models.cells.parent;

import javafx.scene.canvas.Canvas;

import javafx.scene.canvas.GraphicsContext;
import lombok.Getter;
import lombok.Setter;
import ru.utin.magicchess.game.GameField;
import ru.utin.magicchess.models.figures.Figure;

import java.util.List;

@Getter
public abstract class Cell {
    protected int x;
    protected int y;
    protected int size;
    @Setter
    protected Figure figure;

    public Cell(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void activateFigure(int i, int j) {
        figure.activateFigure(i, j);
    }

    public void resetActivateFigure() {
        figure.resetActiveFigure();
    }

    public void draw() {
        Canvas canvas = GameField.getInstance().getCanvas();
        draw(canvas.getGraphicsContext2D());
    }

    protected abstract void draw(GraphicsContext gc);
}

package ru.utin.magicchess.models.cells.parent;

import javafx.scene.canvas.Canvas;

import javafx.scene.canvas.GraphicsContext;
import lombok.Getter;
import lombok.Setter;
import ru.utin.magicchess.game.BaseGameField;
import ru.utin.magicchess.models.cells.BaseChessCell;
import ru.utin.magicchess.models.cells.ResultActiveFigureModel;
import ru.utin.magicchess.models.figures.Figure;

import java.util.List;
import java.util.Objects;

@Getter
public abstract class Cell {
    protected int x;
    protected int y;
    protected int i, j;
    protected int size;
    @Getter
    @Setter
    private boolean isAttacked = false;
    @Setter
    protected Figure figure;

    public Cell(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void setCoordinatesInList(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public ResultActiveFigureModel activateFigure(int i, int j, Cell[][] field) {
        return figure.activateFigure(i, j, field);
    }

    public void resetActivateFigure() {
        figure.resetActiveFigure();
    }

    public void draw(Canvas canvas) {
        draw(canvas.getGraphicsContext2D());
    }

    protected abstract void draw(GraphicsContext gc);

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x && y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

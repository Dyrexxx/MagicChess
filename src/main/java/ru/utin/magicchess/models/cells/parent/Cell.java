package ru.utin.magicchess.models.cells.parent;

import javafx.scene.canvas.Canvas;

import javafx.scene.canvas.GraphicsContext;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.utin.magicchess.game.Analyze;
import ru.utin.magicchess.game.BaseGameField;
import ru.utin.magicchess.models.cells.BaseChessCell;
import ru.utin.magicchess.models.cells.ResultActiveFigureModel;
import ru.utin.magicchess.models.figures.Figure;

import java.util.List;
import java.util.Objects;

@ToString
@Getter
public abstract class Cell implements Cloneable {
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
        ResultActiveFigureModel model = figure.activateFigure(i, j, field);
        Analyze.getInstance().analyzeMoveIfShah(field, model, field[i][j]);
        return model;
    }

    public void draw(Canvas canvas) {
        draw(canvas.getGraphicsContext2D());
    }

    protected abstract void draw(GraphicsContext gc);

    @Override
    public Object clone() {
        Cell cell = null;
        try {
            cell = (Cell) super.clone();
            Figure f = this.figure.clone();
            cell.setFigure(f);
            return cell;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

    }
}

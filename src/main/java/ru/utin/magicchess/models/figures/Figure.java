package ru.utin.magicchess.models.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import lombok.Getter;
import lombok.Setter;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.models.cells.ResultActiveFigureModel;
import ru.utin.magicchess.models.cells.parent.Cell;

import java.util.List;


@Getter
public abstract class Figure {
    private final TypeSide typeSide;
    @Setter
    protected Color activeColor = Color.TRANSPARENT;
    protected Image image;
    @Getter
    protected static final ResultActiveFigureModel resultActiveFigureModel = new ResultActiveFigureModel();

    public Figure(TypeSide typeSide) {
        this.typeSide = typeSide;
    }

    protected abstract void activate(int i, int j, Cell[][] field);

    protected abstract void drawImage(GraphicsContext gc, int x, int y, int size);

    public void draw(GraphicsContext gc, int x, int y, int size) {
        gc.setFill(activeColor);
        gc.fillRect(x, y, size, size);
        drawImage(gc, x, y, size);
    }


    public ResultActiveFigureModel activateFigure(int i, int j, Cell[][] field) {
        activeColor = Color.GREEN;
        activate(i, j, field);

        for (Cell cell : resultActiveFigureModel.getMoveList()) {

            cell.getFigure().setActiveColor(Color.YELLOW);
        }
        for (Cell cell : resultActiveFigureModel.getAttackList()) {
            cell.getFigure().setActiveColor(Color.RED);
        }
        return resultActiveFigureModel;
    }

    public ResultActiveFigureModel getActiveFigure(int i, int j, Cell[][] field) {
        activate(i, j, field);
        return resultActiveFigureModel;
    }

    public void resetActiveFigure() {
        activeColor = Color.TRANSPARENT;

        for (Cell cell : resultActiveFigureModel.getMoveList()) {
            cell.getFigure().setActiveColor(Color.TRANSPARENT);
        }
        for (Cell cell : resultActiveFigureModel.getAttackList()) {
            cell.getFigure().setActiveColor(Color.TRANSPARENT);
        }
        resultActiveFigureModel.clear();
    }
}
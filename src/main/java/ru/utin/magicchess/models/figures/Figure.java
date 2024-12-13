package ru.utin.magicchess.models.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import lombok.Getter;
import lombok.Setter;
import ru.utin.magicchess.game.ActiveFigures;
import ru.utin.magicchess.game.BaseGameField;
import ru.utin.magicchess.models.cells.parent.Cell;


@Getter
public abstract class Figure {
    @Setter
    protected Color activeColor = Color.TRANSPARENT;
    protected Image image;


    protected abstract void activate(int i, int j);

    protected abstract void drawImage(GraphicsContext gc, int x, int y, int size);

    public void draw(GraphicsContext gc, int x, int y, int size) {
        gc.setFill(activeColor);
        gc.fillRect(x, y, size, size);
        drawImage(gc, x, y, size);
    }


    public void activateFigure(int i, int j) {
        activeColor = Color.GREEN;
        activate(i, j);
        for (Cell cell : ActiveFigures.MOVE.getCellList()) {
            cell.getFigure().setActiveColor(Color.YELLOW);
        }
        for (Cell cell : ActiveFigures.ATTACK.getCellList()) {
            cell.getFigure().setActiveColor(Color.RED);
        }
        BaseGameField.getInstance().paint();
    }

    public void resetActiveFigure() {
        activeColor = Color.TRANSPARENT;

        for (Cell cell : ActiveFigures.MOVE.getCellList()) {
            cell.getFigure().setActiveColor(Color.TRANSPARENT);
        }
        for (Cell cell : ActiveFigures.ATTACK.getCellList()) {
            cell.getFigure().setActiveColor(Color.TRANSPARENT);
        }
        ActiveFigures.reset();
        BaseGameField.getInstance().paint();
    }
}
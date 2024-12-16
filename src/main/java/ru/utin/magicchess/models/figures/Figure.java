package ru.utin.magicchess.models.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import lombok.Getter;
import lombok.Setter;
import ru.utin.magicchess.game.Analyze;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.models.cells.ResultActiveFigureModel;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.abstracts.King;


@Getter
public abstract class Figure implements Cloneable {
    private final TypeSide typeSide;
    @Setter
    protected Color activeColor = Color.TRANSPARENT;
    protected Image image;

    public Figure(TypeSide typeSide) {
        this.typeSide = typeSide;
    }

    protected abstract ResultActiveFigureModel activated(int i, int j, Cell[][] field);

    protected abstract void drawImage(GraphicsContext gc, int x, int y, int size);

    public void draw(GraphicsContext gc, int x, int y, int size) {
        gc.setFill(activeColor);
        gc.fillRect(x, y, size, size);
        drawImage(gc, x, y, size);
    }


    public ResultActiveFigureModel activateFigure(int i, int j, Cell[][] field) {
        return activated(i, j, field);
    }


    @Override
    public Figure clone() {
        try {
            Figure clone = (Figure) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
package ru.utin.magicchess.models.figures.chess.abstracts;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import lombok.Getter;
import lombok.Setter;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.models.cells.ResultActiveFigureModel;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.ChessFigure;

@Setter
@Getter
public class King extends ChessFigure {

    protected Color shahColor = Color.TRANSPARENT;
    private Image shahImage = null;

    public King(TypeSide typeSide) {
        super(typeSide);
    }

    @Override
    protected void drawImage(GraphicsContext gc, int x, int y, int size) {
        gc.drawImage(shahImage, x, y, size, size);
        super.drawImage(gc, x, y, size);
    }

    @Override
    protected ResultActiveFigureModel activated(int i, int j, Cell[][] field) {

        run(i - 1, j, field);
        run(i + 1, j, field);
        run(i, j + 1, field);
        run(i, j - 1, field);
        run(i + 1, j - 1, field);
        run(i + 1, j + 1, field);
        run(i - 1, j + 1, field);
        run(i - 1, j - 1, field);
        return super.sendActivatedModel();
    }

}

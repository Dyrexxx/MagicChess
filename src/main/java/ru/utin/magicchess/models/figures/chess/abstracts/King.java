package ru.utin.magicchess.models.figures.chess.abstracts;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import lombok.Getter;
import lombok.Setter;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.cells.ResultActiveFigureModel;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.ChessFigure;

@Getter
@Setter
public class King extends ChessFigure {
    private Image shahImage = null;

    public King(TypeSide typeSide, TypeColorFigure color, Image image) {
        super(typeSide, color);
        this.image = image;
    }

    @Override
    protected void drawImage(GraphicsContext gc, int x, int y, int size) {
        super.drawImage(gc, x, y, size);
        if (shahImage != null) {
            gc.drawImage(shahImage, x, y, size, size);
        }
    }

    @Override
    protected ResultActiveFigureModel activated(int i, int j, Cell[][] field) {
        ResultActiveFigureModel model = new ResultActiveFigureModel();
        run(i - 1, j, field, model);
        run(i + 1, j, field, model);
        run(i, j + 1, field, model);
        run(i, j - 1, field, model);
        run(i + 1, j - 1, field, model);
        run(i + 1, j + 1, field, model);
        run(i - 1, j + 1, field, model);
        run(i - 1, j - 1, field, model);
        return model;
    }
}

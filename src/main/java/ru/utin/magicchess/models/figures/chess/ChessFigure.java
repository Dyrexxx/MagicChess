package ru.utin.magicchess.models.figures.chess;

import javafx.scene.canvas.GraphicsContext;
import lombok.Getter;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.Figure;

import static ru.utin.magicchess.utils.GameUtil.indexIsArray;

@Getter
public abstract class ChessFigure extends Figure {
    protected TypeColorFigure type;
    protected static Cell[][] fieldCopy;


    protected RunType run(int i, int j) {
        if (indexIsArray(i, j)) {
            Cell cell = fieldCopy[i][j];
            Figure figure = cell.getFigure();
            if (figure instanceof ChessFigure) {
                if (((ChessFigure) cell.getFigure()).type != type) {
                    resultActiveFigureModel.getAttackList().add(cell);
                    return RunType.ATTACK;
                } else {
                    return RunType.STOP;
                }

            } else if (figure instanceof NoFigure) {
                resultActiveFigureModel.getMoveList().add(cell);
                return RunType.MOVE;
            }
        }
        return RunType.STOP;
    }

    @Override
    protected void drawImage(GraphicsContext gc, int x, int y, int size) {
        gc.drawImage(image, x, y, size, size);
    }

    @Override
    protected final void activate(int i, int j, Cell[][] field) {
        fieldCopy = field;
        activate(i, j);
    }

    protected abstract void activate(int i, int j);

    @Override
    public void resetActiveFigure() {
        super.resetActiveFigure();

    }
}

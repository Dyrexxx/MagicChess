package ru.utin.magicchess.models.figures.chess;

import javafx.scene.canvas.GraphicsContext;
import lombok.Getter;
import lombok.Setter;
import ru.utin.magicchess.game.ActiveFigures;
import ru.utin.magicchess.game.BaseGameField;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.Figure;

import static ru.utin.magicchess.utils.GameUtil.indexIsArray;

public abstract class ChessFigure extends Figure {
    @Getter
    protected TypeChessFigure type;
    @Getter
    @Setter
    private static Cell[][] fieldCopy;

    protected RunType run(int i, int j) {
        if (indexIsArray(i, j)) {
            Cell cell = fieldCopy[i][j];
            Figure figure = cell.getFigure();
            if (figure instanceof ChessFigure) {
                if (((ChessFigure) cell.getFigure()).type != type) {
                    ActiveFigures.ATTACK.getCellList().add(cell);
                    return RunType.ATTACK;
                } else {
                    return RunType.STOP;
                }

            } else if (figure instanceof NoFigure) {
                ActiveFigures.MOVE.getCellList().add(cell);
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
    protected void activate(int i, int j) {
        fieldCopy = BaseGameField.getInstance().getField().clone();
    }

    @Override
    public void resetActiveFigure() {
        super.resetActiveFigure();
        fieldCopy = null;
    }
}

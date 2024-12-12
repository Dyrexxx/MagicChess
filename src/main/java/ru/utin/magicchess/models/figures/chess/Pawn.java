package ru.utin.magicchess.models.figures.chess;

import javafx.scene.canvas.GraphicsContext;
import lombok.Getter;
import lombok.Setter;
import ru.utin.magicchess.game.ActiveFigures;
import ru.utin.magicchess.game.GameField;
import ru.utin.magicchess.models.cells.parent.Cell;

import static ru.utin.magicchess.utils.GameUtil.indexIsArray;

@Getter
@Setter
public abstract class Pawn extends ChessFigure {
    private boolean beMove = false;

    @Override
    protected void activate(int i, int j) {
        Cell[][] field = GameField.getInstance().getField();
        boolean isBlock = false;

        if (indexIsArray(i, j - 1)) {
            Cell cell = field[i][j - 1];
            if (!(cell.getFigure() instanceof ChessFigure)) {
                ActiveFigures.MOVE.getCellList().add(cell);
            } else {
                isBlock = true;
            }
        }
        if (!beMove && !isBlock) {
            if (indexIsArray(i, j - 2)) {
                Cell cell = field[i][j - 2];
                if (!(cell.getFigure() instanceof ChessFigure)) {
                    ActiveFigures.MOVE.getCellList().add(cell);
                }
            }
        }
        if (indexIsArray(i - 1, j - 1)) {
            Cell cell = field[i - 1][j - 1];
            if (cell.getFigure() instanceof ChessFigure &&
                    ((ChessFigure) cell.getFigure()).type != this.type) {
                ActiveFigures.ATTACK.getCellList().add(cell);
            }
        }
        if (indexIsArray(i + 1, j - 1)) {
            Cell cell = field[i + 1][j - 1];
            if (cell.getFigure() instanceof ChessFigure &&
                    ((ChessFigure) cell.getFigure()).type != this.type) {
                ActiveFigures.ATTACK.getCellList().add(cell);
            }
        }

    }

    @Override
    protected void drawImage(GraphicsContext gc, int x, int y, int size) {
        gc.drawImage(image, x, y, size, size);
    }
}

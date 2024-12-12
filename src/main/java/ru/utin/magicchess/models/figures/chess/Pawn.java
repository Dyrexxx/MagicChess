package ru.utin.magicchess.models.figures.chess;

import javafx.scene.canvas.GraphicsContext;
import lombok.Getter;
import lombok.Setter;
import ru.utin.magicchess.game.ActiveFigures;
import ru.utin.magicchess.game.GameField;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.Figure;

import static ru.utin.magicchess.utils.GameUtil.indexIsArray;

@Getter
@Setter
public abstract class Pawn extends ChessFigure {
    private boolean beMove = false;

    @Override
    protected void activate(int i, int j) {
        super.activate(i, j);
        boolean isBlock = false;
        if (!run(i, j - 1)) {
            isBlock = true;
        }
        if (!beMove && !isBlock) {
            run(i, j - 2);
        }
        attack(i - 1, j - 1);
        attack(i + 1, j - 1);
    }

    private void attack(int i, int j) {
        if (indexIsArray(i, j)) {
            Cell cell = getFieldCopy()[i][j];
            Figure figure = cell.getFigure();
            if (figure instanceof ChessFigure &&
                    ((ChessFigure) cell.getFigure()).type != type) {
                ActiveFigures.ATTACK.getCellList().add(cell);
            }
        }
    }
}

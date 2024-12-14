package ru.utin.magicchess.models.figures.chess.abstracts;

import lombok.Getter;
import lombok.Setter;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.Figure;
import ru.utin.magicchess.models.figures.chess.ChessFigure;
import ru.utin.magicchess.models.figures.chess.NoFigure;

import static ru.utin.magicchess.utils.GameUtil.indexIsArray;

@Getter
@Setter
public abstract class Pawn extends ChessFigure {
    private boolean beMove = false;

    @Override
    protected void activate(int i, int j) {

        boolean isBlock = false;
        if (!move(i, j - 1)) {
            isBlock = true;
        }
        if (!beMove && !isBlock) {
            move(i, j - 2);
        }
        attack(i - 1, j - 1);
        attack(i + 1, j - 1);
    }


    private void attack(int i, int j) {
        if (indexIsArray(i, j)) {
            Cell cell = fieldCopy[i][j];
            Figure figure = cell.getFigure();
            if (figure instanceof ChessFigure &&
                    ((ChessFigure) cell.getFigure()).getType() != type) {
              resultActiveFigureModel.getAttackList().add(cell);
            }
        }
    }
    private boolean move(int i, int j) {
        if (indexIsArray(i, j)) {
            Cell cell = fieldCopy[i][j];
            Figure figure = cell.getFigure();
            if (figure instanceof NoFigure) {
             resultActiveFigureModel.getMoveList().add(cell);
                return true;
            }
        }
        return false;
    }
}
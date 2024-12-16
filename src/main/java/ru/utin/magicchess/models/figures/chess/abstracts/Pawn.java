package ru.utin.magicchess.models.figures.chess.abstracts;

import lombok.Getter;
import lombok.Setter;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.models.cells.ResultActiveFigureModel;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.Figure;
import ru.utin.magicchess.models.figures.chess.ChessFigure;
import ru.utin.magicchess.models.figures.chess.NoFigure;

import static ru.utin.magicchess.utils.GameUtil.indexIsArray;

@Getter
@Setter
public abstract class Pawn extends ChessFigure {
    private boolean beMove = false;

    public Pawn(TypeSide typeSide) {
        super(typeSide);
    }

    @Override
    protected ResultActiveFigureModel activated(int i, int j, Cell[][] field) {
        boolean isBlock = false;
        if (getTypeSide() == TypeSide.DOWN) {
            if (!move(i, j - 1, field)) {
                isBlock = true;
            }
            if (!beMove && !isBlock) {
                move(i, j - 2, field);
            }
            attack(i - 1, j - 1, field);
            attack(i + 1, j - 1, field);
        } else {
            if (!move(i, j + 1, field)) {
                isBlock = true;
            }
            if (!beMove && !isBlock) {
                move(i, j + 2, field);
            }
            attack(i - 1, j + 1, field);
            attack(i + 1, j + 1, field);
        }
        return super.sendActivatedModel();
    }


    private void attack(int i, int j, Cell[][] field) {
        if (indexIsArray(i, j)) {
            Cell cell = field[i][j];
            Figure figure = cell.getFigure();
            if (figure instanceof ChessFigure &&
                    ((ChessFigure) cell.getFigure()).getType() != type) {
                super.getActivatedModel().getAttackList().add(cell);
            }
        }
    }

    private boolean move(int i, int j, Cell[][] field) {
        if (indexIsArray(i, j)) {
            Cell cell = field[i][j];
            Figure figure = cell.getFigure();
            if (figure instanceof NoFigure) {
                super.getActivatedModel().getMoveList().add(cell);
                return true;
            }
        }
        return false;
    }
}

package ru.utin.magicchess.game;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.ChessFigure;
import ru.utin.magicchess.models.figures.chess.NoFigure;
import ru.utin.magicchess.models.figures.chess.Pawn;

@Getter
@ToString
public class ControlClick {
    @Setter
    private boolean block = false;
    private Cell lastCell = null;
    private Cell currentCell = null;

    public void click(Cell cell, int i, int j) {
        if (block) {
            currentCell = cell;
            if (lastCell == currentCell) {
                reset();
            } else if (currentCell.getFigure() instanceof NoFigure) {
                if (move()) {
                    reset();
                }
            } else if (currentCell.getFigure() instanceof ChessFigure) {
                if (attack()) {
                    reset();
                }
            }

        } else {
            if (!(cell.getFigure() instanceof NoFigure)) {
                block = true;
                lastCell = cell;
                lastCell.activateFigure(i, j);
            }
        }
    }

    public boolean attack() {
        if (ActiveFigures.ATTACK.getCellList().contains(currentCell)) {
            if (lastCell.getFigure() instanceof Pawn pawn) {
                if (!pawn.isBeMove()) {
                    pawn.setBeMove(true);
                }
            }
            currentCell.setFigure(lastCell.getFigure());
            lastCell.setFigure(new NoFigure());
            return true;
        }
        return false;
    }

    public boolean move() {
        if (ActiveFigures.MOVE.getCellList().contains(currentCell)) {
            if (lastCell.getFigure() instanceof Pawn pawn) {
                if (!pawn.isBeMove()) {
                    pawn.setBeMove(true);
                }
            }
            currentCell.setFigure(lastCell.getFigure());
            lastCell.setFigure(new NoFigure());
            return true;
        }
        return false;

    }

    private void reset() {
        lastCell.resetActivateFigure();
        block = false;
        lastCell = null;
        currentCell = null;
    }
}
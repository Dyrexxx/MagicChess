package ru.utin.magicchess.game;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.utin.magicchess.MusicClick;
import ru.utin.magicchess.TypeRunFigure;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.ChessFigure;
import ru.utin.magicchess.models.figures.chess.NoFigure;
import ru.utin.magicchess.models.figures.chess.base.Pawn;

@Getter
public class ControlClick {
    private final Cell[][] field;
    @Setter
    private boolean block = false;
    private Cell lastCell = null;
    private Cell currentCell = null;

    public ControlClick(Cell[][] field) {
        this.field = field;
    }

    public void click(Cell cell, int i, int j) {
        if (block) {
            currentCell = cell;
            if (lastCell == currentCell) {
                reset();
            } else if (currentCell.getFigure() instanceof NoFigure) {
                if (move()) {
                    MusicClick.getInstance().play(TypeRunFigure.MOVE);
                    reset();
                }
            } else if (currentCell.getFigure() instanceof ChessFigure) {
                if (attack()) {
                    MusicClick.getInstance().play(TypeRunFigure.ATTACK);
                    reset();
                }
            }

        } else {
            if (!(cell.getFigure() instanceof NoFigure)) {
                block = true;
                lastCell = cell;
                lastCell.activateFigure(i, j, field.clone());
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
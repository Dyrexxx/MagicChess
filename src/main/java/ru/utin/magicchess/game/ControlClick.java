package ru.utin.magicchess.game;

import lombok.Getter;
import lombok.Setter;
import ru.utin.magicchess.MusicClick;
import ru.utin.magicchess.TypeRunFigure;
import ru.utin.magicchess.models.cells.ResultActiveFigureModel;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.ChessFigure;
import ru.utin.magicchess.models.figures.chess.NoFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.Pawn;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ControlClick {
    private final Cell[][] field;
    private final TurnMove turnMove;
    @Setter
    private boolean block = false;
    private Cell lastCell = null;
    private Cell currentCell = null;

    public ControlClick(Cell[][] field, TurnMove turnMove) {
        this.field = field;
        this.turnMove = turnMove;
    }

    public void click(Cell cell, int i, int j) {
        if (block) {
            currentCell = cell;
            if (lastCell == currentCell) {
                reset();
            } else if (currentCell.getFigure() instanceof NoFigure) {
                if (move()) {
                    MusicClick.getInstance().play(TypeRunFigure.MOVE);
                    turnMove.move();
                    reset();
                }
            } else if (currentCell.getFigure() instanceof ChessFigure) {
                if (attack()) {
                    MusicClick.getInstance().play(TypeRunFigure.ATTACK);
                    turnMove.move();
                    reset();
                }
            }

        } else {
            if (!(cell.getFigure() instanceof NoFigure) && ((ChessFigure) cell.getFigure()).getType() == turnMove.getTurnColor()) {
                block = true;
                lastCell = cell;
                ResultActiveFigureModel activeFigureList = lastCell.activateFigure(i, j, field.clone());
                ActiveFigures.ATTACK.fillList(activeFigureList);
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
        ActiveFigures.reset();
        block = false;
        lastCell = null;
        currentCell = null;
    }

    @Getter
    private enum ActiveFigures {
        ATTACK(new ArrayList<>()), MOVE(new ArrayList<>());

        private final List<Cell> activeFigureList;

        ActiveFigures(List<Cell> activeFigureList) {
            this.activeFigureList = activeFigureList;
        }

        public List<Cell> getCellList() {
            return activeFigureList;
        }

        private void clear() {
            activeFigureList.clear();
        }

        public void fillList(ResultActiveFigureModel activeFigureModel) {
            ATTACK.getCellList().addAll(activeFigureModel.getAttackList());
            MOVE.getCellList().addAll(activeFigureModel.getMoveList());
        }

        public static void reset() {
            ATTACK.clear();
            MOVE.clear();
        }
    }
}
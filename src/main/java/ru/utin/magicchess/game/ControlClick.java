package ru.utin.magicchess.game;

import javafx.scene.paint.Color;
import lombok.Getter;
import lombok.Setter;
import ru.utin.magicchess.MusicClick;
import ru.utin.magicchess.TypeRunFigure;
import ru.utin.magicchess.models.cells.ResultActiveFigureModel;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.ChessFigure;
import ru.utin.magicchess.models.figures.chess.NoFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.King;
import ru.utin.magicchess.models.figures.chess.abstracts.Pawn;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ControlClick implements ObserverField, AnalyzableGameField {
    private Cell[][] field;
    private TurnMove turnMove;
    @Setter
    private boolean block = false;
    private Cell lastCell = null;
    private Cell currentCell = null;

    public ControlClick(SubjectField baseGameField) {
        baseGameField.registerObserver(this);
    }

    @Override
    public void update(Cell[][] field, TurnMove turnMove) {
        this.field = field;
        this.turnMove = turnMove;
    }

    @Override
    public TypeSide getTypeColorLastCell() {
        return lastCell.getFigure().getTypeSide();
    }

    public void click(int i, int j) {
        Cell cell = field[i][j];
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
                ResultActiveFigureModel activeFigureList = activatedFigure(i, j);
                ActiveFigures.ATTACK.fillList(activeFigureList);
            }
        }
    }

    private ResultActiveFigureModel activatedFigure(int i, int j) {
        ResultActiveFigureModel activatedModel = lastCell.activateFigure(i, j, field);

        field[i][j].getFigure().setActiveColor(Color.GREEN);
        for (Cell cell : activatedModel.getMoveList()) {
            cell.getFigure().setActiveColor(Color.YELLOW);
        }
        for (Cell cell : activatedModel.getAttackList()) {
            cell.getFigure().setActiveColor(Color.RED);
        }
        return activatedModel;
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
        ActiveFigures.clearList(lastCell);
        Analyze.getInstance().analyzeShah(field, lastCell);
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

        public static void clearList(Cell lastCell) {
            lastCell.getFigure().setActiveColor(Color.TRANSPARENT);
            for (ActiveFigures activeFigures : ActiveFigures.values()) {
                for (Cell cell : activeFigures.getCellList()) {
                    cell.getFigure().setActiveColor(Color.TRANSPARENT);
                }
            }
            ATTACK.clear();
            MOVE.clear();
        }
    }
}
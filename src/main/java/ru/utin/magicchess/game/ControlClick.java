package ru.utin.magicchess.game;

import javafx.scene.paint.Color;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import ru.utin.magicchess.audio.AudioService;
import ru.utin.magicchess.audio.SoundType;
import ru.utin.magicchess.models.cells.ResultActiveFigureModel;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.ChessFigure;
import ru.utin.magicchess.models.figures.chess.NoFigure;
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

    @Getter(AccessLevel.NONE)
    private final List<Cell> moveList = new ArrayList<>();
    @Getter(AccessLevel.NONE)
    private final List<Cell> attackList = new ArrayList<>();

    public ControlClick(SubjectField subject) {
        subject.registerObserver(this);
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
                cancelSelection();
            } else if (currentCell.getFigure() instanceof NoFigure) {
                if (tryMove()) {
                    AudioService.getInstance().playSfx(SoundType.MOVE);
                    afterMove();
                }
            } else if (currentCell.getFigure() instanceof ChessFigure) {
                if (tryAttack()) {
                    AudioService.getInstance().playSfx(SoundType.ATTACK);
                    afterMove();
                }
            }
        } else {
            if (!(cell.getFigure() instanceof NoFigure)
                    && ((ChessFigure) cell.getFigure()).getColor() == turnMove.getTurnColor()) {
                block = true;
                lastCell = cell;
                highlightFigure(i, j);
            }
        }
    }

    private void highlightFigure(int i, int j) {
        ResultActiveFigureModel model = lastCell.activateFigure(i, j, field);
        field[i][j].getFigure().setActiveColor(Color.GREEN);
        model.getMoveList().forEach(c -> c.getFigure().setActiveColor(Color.YELLOW));
        model.getAttackList().forEach(c -> c.getFigure().setActiveColor(Color.RED));
        moveList.addAll(model.getMoveList());
        attackList.addAll(model.getAttackList());
    }

    private boolean tryAttack() {
        if (attackList.contains(currentCell)) {
            markPawnMoved();
            currentCell.setFigure(lastCell.getFigure());
            lastCell.setFigure(new NoFigure());
            return true;
        }
        return false;
    }

    private boolean tryMove() {
        if (moveList.contains(currentCell)) {
            markPawnMoved();
            currentCell.setFigure(lastCell.getFigure());
            lastCell.setFigure(new NoFigure());
            return true;
        }
        return false;
    }

    private void markPawnMoved() {
        if (lastCell.getFigure() instanceof Pawn pawn && !pawn.isMoved()) {
            pawn.setMoved(true);
        }
    }

    private void cancelSelection() {
        clearHighlights();
        block = false;
        lastCell = null;
        currentCell = null;
    }

    private void afterMove() {
        TypeSide moverSide = currentCell.getFigure().getTypeSide();
        TypeSide opponentSide = moverSide == TypeSide.UP ? TypeSide.DOWN : TypeSide.UP;
        turnMove.move();
        clearHighlights();
        Analyze.getInstance().findShah(field);
        if (Analyze.getInstance().findMate(field, opponentSide)) {
            // TODO: показать экран завершения партии
        }
        block = false;
        lastCell = null;
        currentCell = null;
    }

    private void clearHighlights() {
        if (lastCell != null) {
            lastCell.getFigure().setActiveColor(Color.TRANSPARENT);
        }
        moveList.forEach(c -> c.getFigure().setActiveColor(Color.TRANSPARENT));
        attackList.forEach(c -> c.getFigure().setActiveColor(Color.TRANSPARENT));
        moveList.clear();
        attackList.clear();
    }
}

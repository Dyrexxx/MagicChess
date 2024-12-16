package ru.utin.magicchess.game;

import ru.utin.magicchess.models.cells.ResultActiveFigureModel;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.NoFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.King;

import java.util.*;

public class Analyze {
    private static final Analyze instance = new Analyze();
    private boolean isShah = false;
    private boolean isMate = false;

    private Analyze() {
    }

    public static Analyze getInstance() {
        synchronized (instance) {
            return instance;
        }
    }

    public List<Cell> analyzeYourMove(Cell[][] field, Cell cell) {
        Cell[][] fieldCopyForMove = Analyze.copyField(field);
        List<Cell> attackOpponentList = analyzeAttackOpponent(fieldCopyForMove, cell.getFigure().getTypeSide());
        for (Cell attack : attackOpponentList) {
            if (attack.getFigure() instanceof King) {
                System.out.println("Долбаеб!!!!!");
            }
        }

        return attackOpponentList;
    }

    private static Cell[][] copyField(Cell[][] field) {
        Cell[][] fieldCopyForMove = new Cell[field.length][field[0].length];
        for (int i = 0; i < fieldCopyForMove.length; i++) {
            for (int j = 0; j < fieldCopyForMove[0].length; j++) {
                fieldCopyForMove[i][j] = (Cell) field[i][j].clone();
            }
        }
        return fieldCopyForMove;
    }

    private List<Cell> analyzeAttackOpponent(Cell[][] fieldCopy, TypeSide typeSideColorLastCell) {
        List<Cell> attackedCells = new ArrayList<>(16);
        for (int i = 0; i < fieldCopy.length; i++) {
            for (int j = 0; j < fieldCopy[i].length; j++) {
                Cell cell = fieldCopy[i][j];
                if (cell.getFigure().getTypeSide() != typeSideColorLastCell && !(cell.getFigure() instanceof NoFigure)) {
                    addAllUnicalElement(cell.getFigure().getActivatedFigure(i, j, fieldCopy).getAttackList(), attackedCells);
                }
            }
        }
        return attackedCells;
    }

    private static void addAllUnicalElement(List<Cell> cells, List<Cell> unicalElements) {
        for (Cell cell : cells) {
            if (!unicalElements.contains(cell)) {
                unicalElements.add(cell);
            }

        }
    }
}
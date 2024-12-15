package ru.utin.magicchess.game;

import ru.utin.magicchess.models.cells.ResultActiveFigureModel;
import ru.utin.magicchess.models.cells.parent.Cell;

import java.util.*;

public class Analyze {
    private static final Analyze instance = new Analyze();
    private boolean isShah = false;
    private boolean isMate = false;

    private Analyze() {
    }


    private List<Cell> analyzeYourMove(Cell[][] fieldCopy, TypeSide typeSideColorLastCell, InsertCellModel cellModel) {
        List<Cell> cantMoveList = new ArrayList<>();
        Cell cell = cellModel.cell();
        ResultActiveFigureModel runList = cell.getFigure().getActiveFigure(cellModel.x(), cellModel.y(), fieldCopy);
        return null;
    }

    private List<Cell> analyzeAttackOpponent(Cell[][] fieldCopy, TypeSide typeSideColorLastCell) {
        List<Cell> attackedCells = new ArrayList<>(16);
        for (int i = 0; i < fieldCopy.length; i++) {
            for (int j = 0; j < fieldCopy[i].length; j++) {
                Cell cell = fieldCopy[i][j];
                if (cell.getFigure().getTypeSide() != typeSideColorLastCell) {
                    addAllUnicalElement(cell.getFigure().getActiveFigure(i, j, fieldCopy).getAttackList(), attackedCells);
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
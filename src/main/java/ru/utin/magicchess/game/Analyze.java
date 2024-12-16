package ru.utin.magicchess.game;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import lombok.Getter;
import ru.utin.magicchess.models.cells.ResultActiveFigureModel;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.NoFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.King;

import java.util.*;

public class Analyze {
    private static final Analyze instance = new Analyze();
    private King kingShah = null;
    private static final Image shahImage = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\shah.png");

    private Analyze() {
    }

    public static Analyze getInstance() {
        synchronized (instance) {
            return instance;
        }
    }

    private List<Cell> analyzeHodIfShah(Cell[][] field, List<Cell> activatedModel, Cell currentCell) {
        List<Cell> newMoveList = new ArrayList<>();

        for (int i = 0; i < activatedModel.size(); i++) {
            Cell[][] fieldCopy = Analyze.copyField(field);
            Cell move = activatedModel.get(i);
            fieldCopy[move.getI()][move.getJ()].setFigure(currentCell.getFigure());
            fieldCopy[currentCell.getI()][currentCell.getJ()].setFigure(new NoFigure());

            if (!analyzeShah(fieldCopy, currentCell.getFigure().getTypeSide())) {
                newMoveList.add(move);
            }
        }
        return newMoveList;
    }

    public void analyzeMoveIfShah(Cell[][] field, ResultActiveFigureModel activatedModel, Cell currentCell) {
        List<Cell> newAttackList = analyzeHodIfShah(field, activatedModel.getAttackList(), currentCell);
        List<Cell> newMoveList = analyzeHodIfShah(field, activatedModel.getMoveList(), currentCell);
        activatedModel.clear();
        activatedModel.getMoveList().addAll(newMoveList);
        activatedModel.getAttackList().addAll(newAttackList);
    }

    private boolean analyzeShah(Cell[][] field, TypeSide typeSide) {
        List<Cell> attackOpponentList = analyzeAttack(field);
        boolean localIsShah = false;
        for (Cell attack : attackOpponentList) {
            if (attack.getFigure() instanceof King king) {
                if (king.getTypeSide() != typeSide) {
                    return false;
                }
                localIsShah = true;
                kingShah = king;
            }
        }
        if (!localIsShah && kingShah != null) {
            kingShah.setShahImage(null);
            kingShah = null;
        }
        return localIsShah;
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

    public void findMate(Cell[][] field, TypeSide typeSide) {
        Set<Cell> attackList = new HashSet<>();
        Set<Cell> moveList = new HashSet<>();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (!(field[i][j].getFigure() instanceof NoFigure) && field[i][j].getFigure().getTypeSide() == typeSide) {
                    attackList.addAll(field[i][j].activateFigure(field[i][j].getI(), field[i][j].getJ(), field).getAttackList());
                    moveList.addAll(field[i][j].activateFigure(field[i][j].getI(), field[i][j].getJ(), field).getMoveList());
                }
            }
        }
        if(attackList.isEmpty() && moveList.isEmpty()) {
            System.out.println("MATTTTT");
        }
    }

    public void findShah(Cell[][] field) {
        Set<Cell> attackList = new HashSet<>();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (!(field[i][j].getFigure() instanceof NoFigure)) {
                    attackList.addAll(field[i][j].activateFigure(field[i][j].getI(), field[i][j].getJ(), field).getAttackList());
                }
            }
        }
        boolean isShah = false;
        for (Cell cell : attackList) {
            if (cell.getFigure() instanceof King king) {
                king.setShahImage(shahImage);
                isShah = true;
                kingShah = king;
            }
        }
        if (!isShah && kingShah != null) {
            kingShah = null;
        }
    }


    private List<Cell> analyzeAttack(Cell[][] field) {
        List<Cell> attackedCells = new ArrayList<>(16);
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                Cell cell = field[i][j];
                if (!(cell.getFigure() instanceof NoFigure)) {
                    ResultActiveFigureModel copyActiveModel = cell.getFigure().activateFigure(i, j, field);
                    addAllUnicalElement(copyActiveModel.getAttackList(), attackedCells);
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
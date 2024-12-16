package ru.utin.magicchess.game;

import javafx.scene.image.Image;
import lombok.Getter;
import ru.utin.magicchess.models.cells.ResultActiveFigureModel;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.NoFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.King;

import java.util.*;

public class Analyze {
    private static final Analyze instance = new Analyze();
    @Getter
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

            if (!analyzeShah(fieldCopy, currentCell)) {
                newMoveList.add(move);
            } else {
                System.out.println("Блок от шаха " + currentCell);
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

    public void analyzeYourHod(Cell[][] field, ResultActiveFigureModel activatedModel, Cell currentCell) {
        List<Cell> attackList = activatedModel.getAttackList();
        List<Cell> moveList = activatedModel.getMoveList();
        for (Cell attack : attackList) {
            System.out.println(attack);
        }
        System.out.println(moveList);
        for (Cell move : moveList) {
            Cell[][] fieldCopy = Analyze.copyField(field);
            fieldCopy[move.getI()][move.getJ()].setFigure(currentCell.getFigure());
            fieldCopy[currentCell.getI()][currentCell.getJ()].setFigure(new NoFigure());

        }
    }

    public boolean analyzeShah(Cell[][] field, Cell currentCell) {
        List<Cell> attackOpponentList = analyzeAttackAll(field);
        boolean localIsShah = false;
        for (Cell attack : attackOpponentList) {
            if (attack.getFigure() instanceof King king && currentCell.getFigure().getTypeSide() == king.getTypeSide()) {
                localIsShah = true;
                king.setShahImage(shahImage);
                kingShah = king;
            }
        }
        if (!localIsShah && kingShah != null) {
            kingShah.setShahImage(null);
            kingShah = null;
            return false;
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


    private List<Cell> analyzeAttackAll(Cell[][] field) {
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
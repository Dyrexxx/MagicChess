package ru.utin.magicchess.game;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.cells.ResultActiveFigureModel;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.NoFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.King;
import ru.utin.magicchess.utils.ResourceUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Analyze {
    private static final Analyze instance = new Analyze();
    private static final Image SHAH_IMAGE = new Image(ResourceUtil.resourceUrl("/ru/utin/magicchess/images/chess/shah.png"));

    private Analyze() {
    }

    public static Analyze getInstance() {
        return instance;
    }

    /**
     * Фильтрует допустимые ходы/атаки с учётом шаха:
     * убирает из модели те ходы, после которых свой король окажется под шахом.
     */
    public void analyzeMoveIfShah(Cell[][] field, ResultActiveFigureModel model, Cell currentCell) {
        TypeSide typeSide = currentCell.getFigure().getTypeSide();
        List<Cell> validMoves = filterForCheck(field, model.getMoveList(), currentCell, typeSide);
        List<Cell> validAttacks = filterForCheck(field, model.getAttackList(), currentCell, typeSide);
        model.clear();
        model.getMoveList().addAll(validMoves);
        model.getAttackList().addAll(validAttacks);
    }

    /**
     * Обновляет иконку шаха у каждого короля на доске.
     */
    public void findShah(Cell[][] field) {
        Set<Cell> attacked = collectAttacks(field);
        for (Cell[] row : field) {
            for (Cell cell : row) {
                if (cell.getFigure() instanceof King king) {
                    king.setShahImage(attacked.contains(cell) ? SHAH_IMAGE : null);
                }
            }
        }
    }

    /**
     * Проверяет, есть ли у стороны typeSide хотя бы один допустимый ход.
     * Если нет — мат или пат.
     *
     * @return true если нет ни одного хода (мат/пат)
     */
    public boolean findMate(Cell[][] field, TypeSide typeSide) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                Cell cell = field[i][j];
                if (!(cell.getFigure() instanceof NoFigure) && cell.getFigure().getTypeSide() == typeSide) {
                    ResultActiveFigureModel model = cell.activateFigure(i, j, field);
                    if (!model.getMoveList().isEmpty() || !model.getAttackList().isEmpty()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private List<Cell> filterForCheck(Cell[][] field, List<Cell> candidates, Cell currentCell, TypeSide typeSide) {
        List<Cell> valid = new ArrayList<>();
        for (Cell candidate : candidates) {
            Cell[][] copy = copyField(field);
            copy[candidate.getI()][candidate.getJ()].setFigure(currentCell.getFigure());
            copy[currentCell.getI()][currentCell.getJ()].setFigure(new NoFigure());
            if (!isKingInCheck(copy, typeSide)) {
                valid.add(candidate);
            }
        }
        return valid;
    }

    private boolean isKingInCheck(Cell[][] field, TypeSide typeSide) {
        Set<Cell> attacked = collectAttacks(field);
        for (Cell[] row : field) {
            for (Cell cell : row) {
                if (cell.getFigure() instanceof King king && king.getTypeSide() == typeSide) {
                    return attacked.contains(cell);
                }
            }
        }
        return false;
    }

    /**
     * Собирает все клетки, находящиеся под атакой хотя бы одной фигуры.
     * Вызывает activateFigure напрямую на фигуре (не на клетке), чтобы избежать рекурсии.
     */
    private Set<Cell> collectAttacks(Cell[][] field) {
        Set<Cell> attacked = new HashSet<>();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (!(field[i][j].getFigure() instanceof NoFigure)) {
                    attacked.addAll(
                            field[i][j].getFigure().activateFigure(i, j, field).getAttackList()
                    );
                }
            }
        }
        return attacked;
    }

    private static Cell[][] copyField(Cell[][] field) {
        Cell[][] copy = new Cell[field.length][field[0].length];
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[0].length; j++) {
                copy[i][j] = (Cell) field[i][j].clone();
            }
        }

        return copy;
    }
}
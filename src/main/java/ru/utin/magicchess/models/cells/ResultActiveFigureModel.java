package ru.utin.magicchess.models.cells;

import lombok.Getter;
import lombok.Setter;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.RunType;

import java.util.ArrayList;

@Getter
public class ResultActiveFigureModel {
    private ArrayList<Cell> attackList;
    private ArrayList<Cell> moveList;

    public ResultActiveFigureModel() {
        attackList = new ArrayList<>();
        moveList = new ArrayList<>();
    }

    public void clear() {
        moveList.clear();
        attackList.clear();
    }
}

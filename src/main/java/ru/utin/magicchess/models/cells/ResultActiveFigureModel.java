package ru.utin.magicchess.models.cells;

import lombok.Getter;
import lombok.ToString;
import ru.utin.magicchess.models.cells.parent.Cell;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class ResultActiveFigureModel {
    private final List<Cell> attackList;
    private final List<Cell> moveList;

    public ResultActiveFigureModel() {
        attackList = new ArrayList<>();
        moveList = new ArrayList<>();
    }

    public void clear() {
        moveList.clear();
        attackList.clear();
    }
}

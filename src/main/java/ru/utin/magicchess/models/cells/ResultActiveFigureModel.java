package ru.utin.magicchess.models.cells;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.utin.magicchess.models.cells.parent.Cell;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static ResultActiveFigureModel cloneModel(ResultActiveFigureModel original) {
        ResultActiveFigureModel copy = new ResultActiveFigureModel();
        for (Cell cell : original.getAttackList()) {
            copy.getAttackList().add(cell);
        }
        for (Cell cell : original.getMoveList()) {
            copy.getMoveList().add(cell);
        }
        return copy;
    }

    public void clear() {
        moveList.clear();
        attackList.clear();
    }
}

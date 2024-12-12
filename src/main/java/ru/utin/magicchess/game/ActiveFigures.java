package ru.utin.magicchess.game;

import ru.utin.magicchess.models.cells.parent.Cell;

import java.util.ArrayList;
import java.util.List;

public enum ActiveFigures {
    ATTACK(new ArrayList<>()), MOVE(new ArrayList<>());

    private final List<Cell> cells;

    ActiveFigures(List<Cell> cells) {
        this.cells = cells;
    }

    public List<Cell> getCellList() {
        return cells;
    }

    private void clear() {
        cells.clear();
    }

    public static void reset() {
        for (ActiveFigures activeFigures : ActiveFigures.values()) {
            activeFigures.clear();
        }
    }
}

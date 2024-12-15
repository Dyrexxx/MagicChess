package ru.utin.magicchess.game;

import ru.utin.magicchess.models.cells.parent.Cell;

public interface AnalyzableGameField {
    TypeSide getTypeColorLastCell();
    Cell[][] getField();
}

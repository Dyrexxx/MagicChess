package ru.utin.magicchess.game;

import ru.utin.magicchess.models.cells.parent.Cell;

public interface ObserverField {
    void update(Cell[][] field, TurnMove turnMove);
}

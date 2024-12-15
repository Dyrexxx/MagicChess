package ru.utin.magicchess.game;

import lombok.Getter;
import ru.utin.magicchess.models.cells.parent.Cell;

import java.util.Objects;

public record InsertCellModel(Cell cell, int x, int y) {

}

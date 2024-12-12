package ru.utin.magicchess.models.figures.chess;

import javafx.scene.canvas.GraphicsContext;
import ru.utin.magicchess.game.GameField;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.Figure;

import java.util.List;

public abstract class ChessFigure extends Figure {
    protected TypeChessFigure type;
}

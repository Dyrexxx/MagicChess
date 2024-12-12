package ru.utin.magicchess.models.figures.chess.white;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import ru.utin.magicchess.game.GameField;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.ChessFigure;
import ru.utin.magicchess.models.figures.chess.Pawn;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

import java.lang.reflect.Type;
import java.util.List;

public class PawnWhiteFigure extends Pawn implements WhiteFigure {

    public PawnWhiteFigure() {
        type = TypeChessFigure.WHITE;
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\pawn.png");
    }
}

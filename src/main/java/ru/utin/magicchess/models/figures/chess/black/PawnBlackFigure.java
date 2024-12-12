package ru.utin.magicchess.models.figures.chess.black;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.Pawn;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public class PawnBlackFigure extends Pawn {

    public PawnBlackFigure() {
        type = TypeChessFigure.BLACK;
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\black\\bPawn.png");
    }
}

package ru.utin.magicchess.models.figures.chess.white;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.Pawn;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public class PawnWhiteFigure extends Pawn {

    public PawnWhiteFigure() {
        type = TypeChessFigure.WHITE;
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\white\\wPawn.png");
    }
}

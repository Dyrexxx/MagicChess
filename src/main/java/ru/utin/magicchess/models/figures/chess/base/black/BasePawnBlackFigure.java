package ru.utin.magicchess.models.figures.chess.base.black;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.base.Pawn;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public class BasePawnBlackFigure extends Pawn {

    public BasePawnBlackFigure() {
        type = TypeChessFigure.BLACK;
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\black\\bPawn.png");
    }
}

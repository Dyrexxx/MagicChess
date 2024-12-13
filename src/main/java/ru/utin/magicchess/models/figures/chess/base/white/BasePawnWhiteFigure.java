package ru.utin.magicchess.models.figures.chess.base.white;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.base.Pawn;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public class BasePawnWhiteFigure extends Pawn {

    public BasePawnWhiteFigure() {
        type = TypeChessFigure.WHITE;
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\white\\wPawn.png");
    }
}

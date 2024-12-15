package ru.utin.magicchess.models.figures.chess.chessFigures.base.black;

import javafx.scene.image.Image;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.models.figures.chess.abstracts.Pawn;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;
import ru.utin.magicchess.models.figures.chess.color.PawnBlack;

public class BasePawnBlackFigure extends PawnBlack {

    public BasePawnBlackFigure(TypeSide typeSide) {
        super(typeSide);
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\black\\bPawn.png");
    }
}

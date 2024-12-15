package ru.utin.magicchess.models.figures.chess.chessFigures.elf.black;

import javafx.scene.image.Image;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.Pawn;
import ru.utin.magicchess.models.figures.chess.color.PawnBlack;

public class ElfPawnBlackFigure extends PawnBlack {

    public ElfPawnBlackFigure(TypeSide typeSide) {
        super(typeSide);
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\black\\bPawn.png");
    }
}

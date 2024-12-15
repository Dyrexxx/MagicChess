package ru.utin.magicchess.models.figures.chess.chessFigures.elf.white;

import javafx.scene.image.Image;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.Pawn;
import ru.utin.magicchess.models.figures.chess.color.PawnWhite;

public class ElfPawnWhiteFigure extends PawnWhite {

    public ElfPawnWhiteFigure(TypeSide typeSide) {
        super(typeSide);
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\white\\wPawn.png");
    }
}

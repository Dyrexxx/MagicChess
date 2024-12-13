package ru.utin.magicchess.models.figures.chess.elf.black;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;
import ru.utin.magicchess.models.figures.chess.base.Pawn;

public class ElfPawnBlackFigure extends Pawn {

    public ElfPawnBlackFigure() {
        type = TypeChessFigure.BLACK;
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\black\\bPawn.png");
    }
}

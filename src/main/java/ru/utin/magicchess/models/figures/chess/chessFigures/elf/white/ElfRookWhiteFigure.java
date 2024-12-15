package ru.utin.magicchess.models.figures.chess.chessFigures.elf.white;

import javafx.scene.image.Image;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.Rook;
import ru.utin.magicchess.models.figures.chess.color.RookWhite;

public class ElfRookWhiteFigure extends RookWhite {
    public ElfRookWhiteFigure(TypeSide typeSide) {
        super(typeSide);
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\white\\wRook.png");
    }
}

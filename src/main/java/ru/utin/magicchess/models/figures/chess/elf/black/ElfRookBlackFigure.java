package ru.utin.magicchess.models.figures.chess.elf.black;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;
import ru.utin.magicchess.models.figures.chess.base.Rook;

public class ElfRookBlackFigure extends Rook {
    public ElfRookBlackFigure() {
        type = TypeChessFigure.BLACK;
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\black\\bRook.png");
    }
}

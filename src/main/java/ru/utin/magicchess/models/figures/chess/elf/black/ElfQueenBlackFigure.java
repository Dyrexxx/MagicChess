package ru.utin.magicchess.models.figures.chess.elf.black;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;
import ru.utin.magicchess.models.figures.chess.base.Queen;

public class ElfQueenBlackFigure extends Queen {
    public ElfQueenBlackFigure() {
        type = TypeChessFigure.BLACK;
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\black\\bQueen.png");
    }
}

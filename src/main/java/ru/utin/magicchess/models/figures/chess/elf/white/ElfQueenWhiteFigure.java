package ru.utin.magicchess.models.figures.chess.elf.white;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;
import ru.utin.magicchess.models.figures.chess.base.Queen;

public class ElfQueenWhiteFigure extends Queen {
    public ElfQueenWhiteFigure() {
        type = TypeChessFigure.WHITE;
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\white\\wQueen.png");
    }
}

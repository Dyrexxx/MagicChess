package ru.utin.magicchess.models.figures.chess.elf.black;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;
import ru.utin.magicchess.models.figures.chess.base.Horse;

public class ElfHorseBlackFigure extends Horse {
    public ElfHorseBlackFigure() {
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\black\\bHorse.png");
        type = TypeChessFigure.BLACK;
    }
}

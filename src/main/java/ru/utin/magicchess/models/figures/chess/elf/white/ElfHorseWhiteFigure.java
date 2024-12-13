package ru.utin.magicchess.models.figures.chess.elf.white;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;
import ru.utin.magicchess.models.figures.chess.base.Horse;

public class ElfHorseWhiteFigure extends Horse {

    public ElfHorseWhiteFigure() {
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\white\\wHorse.png");
        type = TypeChessFigure.WHITE;
    }
}

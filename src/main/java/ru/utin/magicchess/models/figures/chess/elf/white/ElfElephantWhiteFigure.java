package ru.utin.magicchess.models.figures.chess.elf.white;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;
import ru.utin.magicchess.models.figures.chess.base.Elephant;

public class ElfElephantWhiteFigure extends Elephant {
    public ElfElephantWhiteFigure() {
        type = TypeChessFigure.WHITE;
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\white\\wElephant.png");
    }
}
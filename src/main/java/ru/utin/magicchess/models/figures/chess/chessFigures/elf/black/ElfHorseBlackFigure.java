package ru.utin.magicchess.models.figures.chess.chessFigures.elf.black;

import javafx.scene.image.Image;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.Horse;
import ru.utin.magicchess.models.figures.chess.color.HorseBlack;

public class ElfHorseBlackFigure extends HorseBlack {
    public ElfHorseBlackFigure(TypeSide typeSide) {
        super(typeSide);
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\black\\bHorse.png");
    }
}

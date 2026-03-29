package ru.utin.magicchess.models.figures.chess.chessFigures.elf.black;

import javafx.scene.image.Image;
import ru.utin.magicchess.App;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.models.figures.chess.color.QueenBlack;

public class ElfQueenBlackFigure extends QueenBlack {
    public ElfQueenBlackFigure(TypeSide typeSide) {
        super(typeSide);
        image = new Image(App.class.getResource("/ru/utin/magicchess/images/chess/black/bQueen.png").toExternalForm());
    }
}

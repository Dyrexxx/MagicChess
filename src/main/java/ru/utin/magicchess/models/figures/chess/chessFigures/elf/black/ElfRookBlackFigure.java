package ru.utin.magicchess.models.figures.chess.chessFigures.elf.black;

import javafx.scene.image.Image;
import ru.utin.magicchess.App;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.models.figures.chess.color.RookBlack;

public class ElfRookBlackFigure extends RookBlack {
    public ElfRookBlackFigure(TypeSide typeSide) {
        super(typeSide);
        image = new Image(App.class.getResource("/ru/utin/magicchess/images/chess/black/bRook.png").toExternalForm());
    }
}

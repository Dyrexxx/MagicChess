package ru.utin.magicchess.models.figures.chess.chessFigures.elf.black;

import javafx.scene.image.Image;
import ru.utin.magicchess.App;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.models.figures.chess.color.PawnBlack;

public class ElfPawnBlackFigure extends PawnBlack {

    public ElfPawnBlackFigure(TypeSide typeSide) {
        super(typeSide);
        image = new Image(App.class.getResource("/ru/utin/magicchess/images/chess/black/bPawn.png").toExternalForm());
    }
}

package ru.utin.magicchess.models.figures.chess.chessFigures.elf.white;

import javafx.scene.image.Image;
import ru.utin.magicchess.App;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.models.figures.chess.color.ElephantWhite;

public class ElfElephantWhiteFigure extends ElephantWhite {
    public ElfElephantWhiteFigure(TypeSide typeSide) {
        super(typeSide);
        image = new Image(App.class.getResource("/ru/utin/magicchess/images/chess/white/wElephant.png").toExternalForm());
    }
}

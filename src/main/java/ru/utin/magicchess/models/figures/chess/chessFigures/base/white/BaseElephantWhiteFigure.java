package ru.utin.magicchess.models.figures.chess.chessFigures.base.white;

import javafx.scene.image.Image;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.Elephant;
import ru.utin.magicchess.models.figures.chess.color.ElephantWhite;

public class BaseElephantWhiteFigure extends ElephantWhite {
    public BaseElephantWhiteFigure(TypeSide typeSide) {
        super(typeSide);
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\white\\wElephant.png");
    }
}

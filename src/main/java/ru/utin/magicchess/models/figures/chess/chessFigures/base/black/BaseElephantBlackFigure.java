package ru.utin.magicchess.models.figures.chess.chessFigures.base.black;

import javafx.scene.image.Image;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.Elephant;
import ru.utin.magicchess.models.figures.chess.color.ElephantBlack;

public class BaseElephantBlackFigure extends ElephantBlack {
    public BaseElephantBlackFigure(TypeSide typeSide) {
        super(typeSide);
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\black\\bElephant.png");
    }
}

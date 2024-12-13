package ru.utin.magicchess.models.figures.chess.base.white;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.base.Elephant;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public class BaseElephantWhiteFigure extends Elephant {
    public BaseElephantWhiteFigure() {
        type = TypeChessFigure.WHITE;
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\white\\wElephant.png");
    }
}

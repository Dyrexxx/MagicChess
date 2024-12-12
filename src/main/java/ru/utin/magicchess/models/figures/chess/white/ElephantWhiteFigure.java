package ru.utin.magicchess.models.figures.chess.white;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.Elephant;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public class ElephantWhiteFigure extends Elephant {
    public ElephantWhiteFigure() {
        type = TypeChessFigure.WHITE;
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\white\\wElephant.png");
    }
}

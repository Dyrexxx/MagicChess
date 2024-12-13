package ru.utin.magicchess.models.figures.chess.base.white;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.base.Horse;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public class BaseHorseWhiteFigure extends Horse {

    public BaseHorseWhiteFigure() {
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\white\\wHorse.png");
        type = TypeChessFigure.WHITE;
    }
}

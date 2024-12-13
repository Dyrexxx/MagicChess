package ru.utin.magicchess.models.figures.chess.base.black;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.base.Horse;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public class BaseHorseBlackFigure extends Horse {
    public BaseHorseBlackFigure() {
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\black\\bHorse.png");
        type = TypeChessFigure.BLACK;
    }
}

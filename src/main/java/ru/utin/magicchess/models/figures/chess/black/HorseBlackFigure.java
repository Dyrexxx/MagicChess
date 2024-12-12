package ru.utin.magicchess.models.figures.chess.black;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.Horse;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public class HorseBlackFigure extends Horse {
    public HorseBlackFigure() {
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\black\\bHorse.png");
        type = TypeChessFigure.BLACK;
    }
}

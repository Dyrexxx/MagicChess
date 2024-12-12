package ru.utin.magicchess.models.figures.chess.white;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.Horse;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public class HorseWhiteFigure extends Horse {

    public HorseWhiteFigure() {
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\white\\wHorse.png");
        type = TypeChessFigure.WHITE;
    }
}

package ru.utin.magicchess.models.figures.chess.chessFigures.base.white;

import javafx.scene.image.Image;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.Horse;
import ru.utin.magicchess.models.figures.chess.color.HorseWhite;

public class BaseHorseWhiteFigure extends HorseWhite {

    public BaseHorseWhiteFigure() {
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\white\\wHorse.png");
    }
}

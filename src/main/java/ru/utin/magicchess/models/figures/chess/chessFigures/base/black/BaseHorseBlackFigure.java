package ru.utin.magicchess.models.figures.chess.chessFigures.base.black;

import javafx.scene.image.Image;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.Horse;
import ru.utin.magicchess.models.figures.chess.color.HorseBlack;

public class BaseHorseBlackFigure extends HorseBlack {
    public BaseHorseBlackFigure() {
        image = new Image("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\images\\chess\\black\\bHorse.png");
    }
}

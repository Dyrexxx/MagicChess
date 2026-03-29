package ru.utin.magicchess.game;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

/**
 * Хранит настройки текущей игры: цвета сторон и расы фигур.
 * Является синглтоном, так как настройки передаются между экранами приложения.
 */
@Getter
@Setter
@ToString
public class SettingFieldGame {
    private static SettingFieldGame instance;
    private TypeColorFigure myColorSide;
    private TypeColorFigure opponentColorSide;
    private TypeChessFigure mySpecies;
    private TypeChessFigure opponentSpecies;

    private SettingFieldGame() {
    }

    public static SettingFieldGame getInstance() {
        if (instance == null) {
            synchronized (SettingFieldGame.class) {
                if (instance == null) {
                    instance = new SettingFieldGame();
                }
            }
        }
        return instance;
    }
}

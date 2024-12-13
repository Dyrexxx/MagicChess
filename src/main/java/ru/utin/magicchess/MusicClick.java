package ru.utin.magicchess;

import javafx.scene.media.MediaPlayer;
import ru.utin.magicchess.game.ActiveFigures;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public class MusicClick {
    private static MusicClick instance;
    private MediaPlayer mediaPlayer;

    private MusicClick() {
    }

    public void play(TypeRunFigure runFigureType) {
        if (runFigureType == TypeRunFigure.ATTACK) {

        } else if (runFigureType == TypeRunFigure.MOVE) {

        }

    }

    public static MusicClick getInstance() {
        if (instance == null) {
            synchronized (MusicClick.class) {
                if (instance == null) {
                    instance = new MusicClick();
                }
            }
        }
        return instance;
    }
}

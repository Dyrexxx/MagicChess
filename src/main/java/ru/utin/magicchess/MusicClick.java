package ru.utin.magicchess;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class MusicClick{
    private static MusicClick instance;
    private MediaPlayer mediaPlayer;
    private static final Media MEDIA_MOVE = new Media(new File("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\music\\soundMoveFigure.mp3").toURI().toString());
    private static final Media MEDIA_ATTACK = new Media(new File("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\music\\odin-udar-boxing.mp3").toURI().toString());

    private MusicClick() {
    }

    public synchronized void play(TypeRunFigure runFigureType) {
        if (mediaPlayer != null) {
            dispose();
        }
        if (runFigureType == TypeRunFigure.ATTACK) {
            mediaPlayer = new MediaPlayer(MEDIA_ATTACK);
        }
        if (runFigureType == TypeRunFigure.MOVE) {
            mediaPlayer = new MediaPlayer(MEDIA_MOVE);
        }

        new Thread(() -> mediaPlayer.play()).start();
    }

    private synchronized void dispose() {
        mediaPlayer.stop();
        mediaPlayer.dispose();
        mediaPlayer = null;

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
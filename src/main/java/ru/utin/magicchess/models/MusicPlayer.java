package ru.utin.magicchess.models;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import lombok.Getter;

import java.io.File;

@Getter
public class MusicPlayer {
    private MediaPlayer mediaPlayer;

    public void play() {
        Media music = new Media(new File("E:\\ideaProject\\MagicChess\\src\\main\\resources\\ru\\utin\\magicchess\\music\\menu.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(music);
        mediaPlayer.setVolume(0.05);
        mediaPlayer.setOnEndOfMedia(() -> {
            dispose();
            mediaPlayer = null;
        });
        mediaPlayer.setOnError(this::dispose);
        mediaPlayer.setOnStopped(this::dispose);
        mediaPlayer.setOnRepeat(this::dispose);
        mediaPlayer.play();
    }

    private void dispose() {
        mediaPlayer.stop();
        mediaPlayer.dispose();
    }
}

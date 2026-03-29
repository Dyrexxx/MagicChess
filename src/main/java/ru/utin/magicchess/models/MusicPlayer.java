package ru.utin.magicchess.models;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import lombok.Getter;
import ru.utin.magicchess.utils.ResourceUtil;

@Getter
public class MusicPlayer {
    private MediaPlayer mediaPlayer;
    private static final Media music = new Media(ResourceUtil.resourceUrl("/ru/utin/magicchess/music/menu2.mp3"));

    public synchronized void play() {

        mediaPlayer = new MediaPlayer(music);
        mediaPlayer.setVolume(0.05);
        mediaPlayer.setOnEndOfMedia(this::dispose);
        mediaPlayer.setOnError(this::dispose);
        mediaPlayer.setOnStopped(this::dispose);
        mediaPlayer.setOnRepeat(this::dispose);

        mediaPlayer.play();
    }

    private synchronized void dispose() {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
            } finally {
                mediaPlayer.dispose();
                mediaPlayer = null;
            }
        }
    }
}

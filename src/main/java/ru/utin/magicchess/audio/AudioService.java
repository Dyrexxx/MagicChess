package ru.utin.magicchess.audio;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import ru.utin.magicchess.utils.ResourceUtil;

import java.util.EnumMap;
import java.util.Map;

public final class AudioService {
    private final Map<SoundType, Media> sounds = new EnumMap<>(SoundType.class);

    private MediaPlayer sfxPlayer;
    private MediaPlayer bgmPlayer;

    public AudioService() {
        for (SoundType type : SoundType.values()) {
            sounds.put(type, new Media(ResourceUtil.resourceUrl(type.getPath())));
        }
    }

    public synchronized void playSfx(SoundType type) {
        disposeSfx();
        sfxPlayer = new MediaPlayer(sounds.get(type));
        sfxPlayer.setVolume(type.getVolume());
        sfxPlayer.play();
    }

    public synchronized void playBgm(SoundType type) {
        disposeBgm();
        bgmPlayer = new MediaPlayer(sounds.get(type));
        bgmPlayer.setVolume(type.getVolume());
        bgmPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        bgmPlayer.setOnError(this::disposeBgm);
        bgmPlayer.play();
    }

    public synchronized void stopBgm() {
        disposeBgm();
    }

    private synchronized void disposeSfx() {
        if (sfxPlayer != null) {
            try {
                sfxPlayer.stop();
            } finally {
                sfxPlayer.dispose();
                sfxPlayer = null;
            }
        }
    }

    private synchronized void disposeBgm() {
        if (bgmPlayer != null) {
            MediaPlayer player = bgmPlayer;
            bgmPlayer = null;
            try {
                player.stop();
            } finally {
                player.dispose();
            }
        }
    }
}

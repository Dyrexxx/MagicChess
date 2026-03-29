package ru.utin.magicchess.audio;

public enum SoundType {
    MOVE("/ru/utin/magicchess/music/soundMoveFigure.mp3", 1.0),
    ATTACK("/ru/utin/magicchess/music/odin-udar-boxing.mp3", 1.0),
    MENU_MUSIC("/ru/utin/magicchess/music/menu2.mp3", 0.05);

    private final String path;
    private final double volume;

    SoundType(String path, double volume) {
        this.path = path;
        this.volume = volume;
    }

    public String getPath() {
        return path;
    }

    public double getVolume() {
        return volume;
    }
}

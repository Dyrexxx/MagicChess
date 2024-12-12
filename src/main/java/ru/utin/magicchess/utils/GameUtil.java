package ru.utin.magicchess.utils;

public class GameUtil {
    public static boolean indexIsArray(int i, int j) {
        return i >= 0 && i < 8 && j >= 0 && j < 8;
    }
}

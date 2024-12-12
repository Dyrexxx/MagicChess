package ru.utin.magicchess.models;

import lombok.Getter;

@Getter
public class Coord {
    private int x;
    private int y;
    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

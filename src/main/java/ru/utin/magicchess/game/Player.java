package ru.utin.magicchess.game;

import lombok.Getter;
import ru.utin.magicchess.game.factory.TypeColorFigure;

@Getter
public class Player {
    private final TypeColorFigure color;

    public Player(TypeColorFigure color) {
        this.color = color;
    }
}
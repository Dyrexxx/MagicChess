package ru.utin.magicchess.game;

import lombok.Getter;
import lombok.Setter;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.cells.parent.Cell;

import java.util.ArrayList;

@Getter
@Setter
public class Player {
    private String name;
    private final TypeColorFigure color;

    public Player(TypeColorFigure color) {
        this.color = color;
        name = "Безымянный";
    }

}
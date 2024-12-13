package ru.utin.magicchess.game.factory;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum TypeColorFigure {
    BLACK("Черный"),
    WHITE("Белый");
    private final String title;
    TypeColorFigure(String title) {
        this.title = title;
    }
}

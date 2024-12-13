package ru.utin.magicchess.models.figures.chess;

import javafx.util.StringConverter;
import lombok.ToString;

public enum TypeChessFigure {
    WHITE("Белые"),
    BLACK("Черные"),
    ELF("Эльфы"),
    NONE("Не указано");

    private final String title;

    TypeChessFigure(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}

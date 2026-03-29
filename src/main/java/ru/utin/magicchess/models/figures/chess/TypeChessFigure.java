package ru.utin.magicchess.models.figures.chess;

public enum TypeChessFigure {
    CLASSIC("Классические"),
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

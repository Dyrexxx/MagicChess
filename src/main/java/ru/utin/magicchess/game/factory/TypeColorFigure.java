package ru.utin.magicchess.game.factory;

public enum TypeColorFigure {
    BLACK("Черный"),
    WHITE("Белый");
    private final String title;

    TypeColorFigure(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

    public String getTitle() {
        return title;
    }
}

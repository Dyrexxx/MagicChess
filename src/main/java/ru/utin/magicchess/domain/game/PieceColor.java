package ru.utin.magicchess.domain.game;

public enum PieceColor {
    BLACK("Черный"),
    WHITE("Белый");

    private final String title;

    PieceColor(String title) {
        this.title = title;
    }

    public PieceColor opposite() {
        return this == WHITE ? BLACK : WHITE;
    }

    @Override
    public String toString() {
        return title;
    }
}

package ru.utin.magicchess.domain.game;

public record BoardPosition(int column, int row) {
    public boolean isInsideBoard() {
        return column >= 0 && column < Board.SIZE && row >= 0 && row < Board.SIZE;
    }
}

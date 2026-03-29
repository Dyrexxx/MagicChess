package ru.utin.magicchess.domain.game;

public enum BoardSide {
    UP(1),
    DOWN(-1);

    private final int pawnDirection;

    BoardSide(int pawnDirection) {
        this.pawnDirection = pawnDirection;
    }

    public int pawnDirection() {
        return pawnDirection;
    }
}

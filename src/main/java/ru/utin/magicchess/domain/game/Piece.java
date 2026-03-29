package ru.utin.magicchess.domain.game;

import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public record Piece(
        PieceType type,
        PieceColor color,
        BoardSide side,
        TypeChessFigure species,
        boolean moved
) {
    public Piece markMoved() {
        return new Piece(type, color, side, species, true);
    }
}

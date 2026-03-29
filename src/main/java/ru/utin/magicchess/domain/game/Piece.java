package ru.utin.magicchess.domain.game;

import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public record Piece(
        PieceType type,
        TypeColorFigure color,
        TypeSide side,
        TypeChessFigure species,
        boolean moved
) {
    public Piece markMoved() {
        return new Piece(type, color, side, species, true);
    }
}

package ru.utin.magicchess.domain.game;

public record Move(
        BoardPosition from,
        BoardPosition to,
        Piece movedPiece,
        Piece capturedPiece,
        MoveKind kind
) {
}

package ru.utin.magicchess.ui.resources;

import ru.utin.magicchess.domain.game.PieceColor;
import ru.utin.magicchess.domain.game.PieceType;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public record PieceSpriteKey(
        TypeChessFigure species,
        PieceColor color,
        PieceType pieceType
) {
}

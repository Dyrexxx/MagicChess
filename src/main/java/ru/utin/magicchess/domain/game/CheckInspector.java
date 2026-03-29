package ru.utin.magicchess.domain.game;

import ru.utin.magicchess.game.factory.TypeColorFigure;

import java.util.List;

public class CheckInspector {
    private final LegalMoveService legalMoveService;

    public CheckInspector(LegalMoveService legalMoveService) {
        this.legalMoveService = legalMoveService;
    }

    public boolean isKingInCheck(Board board, TypeColorFigure color) {
        BoardPosition kingPosition = board.findKing(color);
        if (kingPosition == null) {
            return false;
        }
        TypeColorFigure attackerColor = color == TypeColorFigure.WHITE ? TypeColorFigure.BLACK : TypeColorFigure.WHITE;
        for (int column = 0; column < Board.SIZE; column++) {
            for (int row = 0; row < Board.SIZE; row++) {
                BoardPosition position = new BoardPosition(column, row);
                Piece piece = board.getPiece(position);
                if (piece == null || piece.color() != attackerColor) {
                    continue;
                }
                List<MoveOption> attacks = legalMoveService.pseudoLegalMoves(board, position, true);
                boolean attacksKing = attacks.stream()
                        .map(MoveOption::target)
                        .anyMatch(kingPosition::equals);
                if (attacksKing) {
                    return true;
                }
            }
        }
        return false;
    }
}

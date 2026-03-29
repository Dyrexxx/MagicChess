package ru.utin.magicchess.domain.game;

public final class BoardFactory {
    private static final PieceType[] BACK_ROW = {
            PieceType.ROOK,
            PieceType.KNIGHT,
            PieceType.BISHOP,
            PieceType.QUEEN,
            PieceType.KING,
            PieceType.BISHOP,
            PieceType.KNIGHT,
            PieceType.ROOK
    };

    private BoardFactory() {
    }

    public static Board create(GameSettings settings) {
        Board board = new Board();
        fillSide(board, settings, BoardSide.UP, 0, 1);
        fillSide(board, settings, BoardSide.DOWN, 7, 6);
        return board;
    }

    private static void fillSide(Board board, GameSettings settings, BoardSide side, int backRow, int pawnRow) {
        for (int column = 0; column < Board.SIZE; column++) {
            board.setPiece(
                    new BoardPosition(column, pawnRow),
                    new Piece(PieceType.PAWN, settings.colorForSide(side), side, settings.speciesForSide(side), false)
            );
            board.setPiece(
                    new BoardPosition(column, backRow),
                    new Piece(BACK_ROW[column], settings.colorForSide(side), side, settings.speciesForSide(side), false)
            );
        }
    }
}

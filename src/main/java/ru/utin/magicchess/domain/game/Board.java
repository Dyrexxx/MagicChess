package ru.utin.magicchess.domain.game;

public class Board {
    public static final int SIZE = 8;

    private final Piece[][] pieces;

    public Board() {
        this.pieces = new Piece[SIZE][SIZE];
    }

    private Board(Piece[][] pieces) {
        this.pieces = pieces;
    }

    public Piece getPiece(BoardPosition position) {
        return pieces[position.column()][position.row()];
    }

    public void setPiece(BoardPosition position, Piece piece) {
        pieces[position.column()][position.row()] = piece;
    }

    public boolean isEmpty(BoardPosition position) {
        return getPiece(position) == null;
    }

    public Board copy() {
        Piece[][] copy = new Piece[SIZE][SIZE];
        for (int column = 0; column < SIZE; column++) {
            System.arraycopy(pieces[column], 0, copy[column], 0, SIZE);
        }
        return new Board(copy);
    }

    public BoardPosition findKing(PieceColor color) {
        for (int column = 0; column < SIZE; column++) {
            for (int row = 0; row < SIZE; row++) {
                Piece piece = pieces[column][row];
                if (piece != null && piece.type() == PieceType.KING && piece.color() == color) {
                    return new BoardPosition(column, row);
                }
            }
        }
        return null;
    }
}

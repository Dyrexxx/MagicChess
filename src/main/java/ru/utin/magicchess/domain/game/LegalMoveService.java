package ru.utin.magicchess.domain.game;

import java.util.ArrayList;
import java.util.List;

public class LegalMoveService {
    private CheckInspector checkInspector;

    public void setCheckInspector(CheckInspector checkInspector) {
        this.checkInspector = checkInspector;
    }

    public List<MoveOption> legalMoves(Board board, BoardPosition from) {
        Piece piece = board.getPiece(from);
        if (piece == null) {
            return List.of();
        }
        List<MoveOption> candidates = pseudoLegalMoves(board, from, false);
        List<MoveOption> legalMoves = new ArrayList<>();
        for (MoveOption candidate : candidates) {
            Board simulatedBoard = applyMove(board, from, candidate);
            if (!checkInspector.isKingInCheck(simulatedBoard, piece.color())) {
                legalMoves.add(candidate);
            }
        }
        return legalMoves;
    }

    public List<MoveOption> pseudoLegalMoves(Board board, BoardPosition from, boolean attacksOnly) {
        Piece piece = board.getPiece(from);
        if (piece == null) {
            return List.of();
        }
        return switch (piece.type()) {
            case KING -> kingMoves(board, from, piece);
            case QUEEN -> slidingMoves(board, from, piece, new int[][]{
                    {-1, -1}, {-1, 1}, {1, -1}, {1, 1},
                    {-1, 0}, {1, 0}, {0, -1}, {0, 1}
            });
            case ROOK -> slidingMoves(board, from, piece, new int[][]{
                    {-1, 0}, {1, 0}, {0, -1}, {0, 1}
            });
            case BISHOP -> slidingMoves(board, from, piece, new int[][]{
                    {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
            });
            case KNIGHT -> knightMoves(board, from, piece);
            case PAWN -> pawnMoves(board, from, piece, attacksOnly);
        };
    }

    public Board applyMove(Board board, BoardPosition from, MoveOption option) {
        Board copy = board.copy();
        Piece movedPiece = copy.getPiece(from);
        copy.setPiece(from, null);
        copy.setPiece(option.target(), movedPiece == null ? null : movedPiece.markMoved());
        return copy;
    }

    private List<MoveOption> kingMoves(Board board, BoardPosition from, Piece piece) {
        List<MoveOption> moves = new ArrayList<>();
        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };
        for (int[] direction : directions) {
            addMoveIfPossible(board, piece, moves, from.column() + direction[0], from.row() + direction[1]);
        }
        return moves;
    }

    private List<MoveOption> knightMoves(Board board, BoardPosition from, Piece piece) {
        List<MoveOption> moves = new ArrayList<>();
        int[][] offsets = {
                {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
                {1, -2}, {1, 2}, {2, -1}, {2, 1}
        };
        for (int[] offset : offsets) {
            addMoveIfPossible(board, piece, moves, from.column() + offset[0], from.row() + offset[1]);
        }
        return moves;
    }

    private List<MoveOption> slidingMoves(Board board, BoardPosition from, Piece piece, int[][] directions) {
        List<MoveOption> moves = new ArrayList<>();
        for (int[] direction : directions) {
            int column = from.column() + direction[0];
            int row = from.row() + direction[1];
            while (new BoardPosition(column, row).isInsideBoard()) {
                Piece targetPiece = board.getPiece(new BoardPosition(column, row));
                if (targetPiece == null) {
                    moves.add(new MoveOption(new BoardPosition(column, row), MoveKind.MOVE));
                } else {
                    if (targetPiece.color() != piece.color()) {
                        moves.add(new MoveOption(new BoardPosition(column, row), MoveKind.ATTACK));
                    }
                    break;
                }
                column += direction[0];
                row += direction[1];
            }
        }
        return moves;
    }

    private List<MoveOption> pawnMoves(Board board, BoardPosition from, Piece piece, boolean attacksOnly) {
        List<MoveOption> moves = new ArrayList<>();
        int direction = piece.side().pawnDirection();
        if (!attacksOnly) {
            BoardPosition oneStep = new BoardPosition(from.column(), from.row() + direction);
            if (oneStep.isInsideBoard() && board.isEmpty(oneStep)) {
                moves.add(new MoveOption(oneStep, MoveKind.MOVE));
                BoardPosition twoStep = new BoardPosition(from.column(), from.row() + (direction * 2));
                if (!piece.moved() && twoStep.isInsideBoard() && board.isEmpty(twoStep)) {
                    moves.add(new MoveOption(twoStep, MoveKind.MOVE));
                }
            }
        }

        addPawnAttack(board, piece, moves, new BoardPosition(from.column() - 1, from.row() + direction), attacksOnly);
        addPawnAttack(board, piece, moves, new BoardPosition(from.column() + 1, from.row() + direction), attacksOnly);
        return moves;
    }

    private void addPawnAttack(
            Board board,
            Piece piece,
            List<MoveOption> moves,
            BoardPosition position,
            boolean attacksOnly
    ) {
        if (!position.isInsideBoard()) {
            return;
        }
        Piece targetPiece = board.getPiece(position);
        if (attacksOnly) {
            moves.add(new MoveOption(position, MoveKind.ATTACK));
            return;
        }
        if (targetPiece != null && targetPiece.color() != piece.color()) {
            moves.add(new MoveOption(position, MoveKind.ATTACK));
        }
    }

    private void addMoveIfPossible(Board board, Piece piece, List<MoveOption> moves, int column, int row) {
        BoardPosition position = new BoardPosition(column, row);
        if (!position.isInsideBoard()) {
            return;
        }
        Piece targetPiece = board.getPiece(position);
        if (targetPiece == null) {
            moves.add(new MoveOption(position, MoveKind.MOVE));
            return;
        }
        if (targetPiece.color() != piece.color()) {
            moves.add(new MoveOption(position, MoveKind.ATTACK));
        }
    }
}

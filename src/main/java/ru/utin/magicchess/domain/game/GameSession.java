package ru.utin.magicchess.domain.game;

import ru.utin.magicchess.game.factory.TypeColorFigure;

import java.util.List;

public class GameSession {
    private final LegalMoveService legalMoveService;
    private final CheckInspector checkInspector;
    private final GameSettings settings;

    private Board board;
    private TypeColorFigure turnColor;
    private GameStatus status;
    private TypeColorFigure winnerColor;

    public GameSession(Board board, TypeColorFigure turnColor, GameSettings settings) {
        this.settings = settings;
        this.board = board;
        this.turnColor = turnColor;
        this.legalMoveService = new LegalMoveService();
        this.checkInspector = new CheckInspector(legalMoveService);
        legalMoveService.setCheckInspector(checkInspector);
        recalculateStatus();
    }

    public static GameSession create(GameSettings settings) {
        return new GameSession(BoardFactory.create(settings), TypeColorFigure.WHITE, settings);
    }

    public Board board() {
        return board;
    }

    public TypeColorFigure turnColor() {
        return turnColor;
    }

    public GameStatus status() {
        return status;
    }

    public TypeColorFigure winnerColor() {
        return winnerColor;
    }

    public GameSettings settings() {
        return settings;
    }

    public boolean canSelect(BoardPosition position) {
        Piece piece = board.getPiece(position);
        return piece != null && piece.color() == turnColor;
    }

    public List<MoveOption> legalMovesFrom(BoardPosition position) {
        if (!canSelect(position)) {
            return List.of();
        }
        return legalMoveService.legalMoves(board, position);
    }

    public Move move(BoardPosition from, BoardPosition to) {
        List<MoveOption> legalMoves = legalMovesFrom(from);
        MoveOption option = legalMoves.stream()
                .filter(candidate -> candidate.target().equals(to))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Illegal move from " + from + " to " + to));

        Piece movedPiece = board.getPiece(from);
        Piece capturedPiece = board.getPiece(to);
        board = legalMoveService.applyMove(board, from, option);
        turnColor = opposite(turnColor);
        recalculateStatus();
        return new Move(from, to, movedPiece, capturedPiece, option.kind());
    }

    public boolean isKingInCheck(TypeColorFigure color) {
        return checkInspector.isKingInCheck(board, color);
    }

    public String statusText() {
        return switch (status) {
            case ACTIVE -> "Ход: " + turnColor;
            case CHECK -> "Шах. Ход: " + turnColor;
            case CHECKMATE -> "Мат. Победил: " + winnerColor;
            case STALEMATE -> "Пат. Ничья";
        };
    }

    private void recalculateStatus() {
        boolean inCheck = checkInspector.isKingInCheck(board, turnColor);
        boolean hasLegalMoves = hasAnyLegalMove(turnColor);
        if (!hasLegalMoves) {
            if (inCheck) {
                status = GameStatus.CHECKMATE;
                winnerColor = opposite(turnColor);
            } else {
                status = GameStatus.STALEMATE;
                winnerColor = null;
            }
            return;
        }
        winnerColor = null;
        status = inCheck ? GameStatus.CHECK : GameStatus.ACTIVE;
    }

    private boolean hasAnyLegalMove(TypeColorFigure color) {
        for (int column = 0; column < Board.SIZE; column++) {
            for (int row = 0; row < Board.SIZE; row++) {
                BoardPosition position = new BoardPosition(column, row);
                Piece piece = board.getPiece(position);
                if (piece != null && piece.color() == color && !legalMoveService.legalMoves(board, position).isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private TypeColorFigure opposite(TypeColorFigure color) {
        return color == TypeColorFigure.WHITE ? TypeColorFigure.BLACK : TypeColorFigure.WHITE;
    }
}

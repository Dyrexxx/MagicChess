package ru.utin.magicchess.domain.game;

import org.junit.jupiter.api.Test;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameSessionTest {
    @Test
    void shouldCreateClassicBoardWithExpectedPieces() {
        GameSession session = GameSession.create(GameSettings.defaultSettings());

        assertNotNull(session.board().getPiece(new BoardPosition(0, 7)));
        assertEquals(PieceType.ROOK, session.board().getPiece(new BoardPosition(0, 7)).type());
        assertEquals(PieceType.KING, session.board().getPiece(new BoardPosition(4, 0)).type());
        assertEquals(PieceType.PAWN, session.board().getPiece(new BoardPosition(3, 6)).type());
        assertEquals(TypeColorFigure.WHITE, session.turnColor());
        assertEquals(GameStatus.ACTIVE, session.status());
    }

    @Test
    void shouldMovePawnTwoSquaresOnFirstMoveAndSwitchTurn() {
        GameSession session = GameSession.create(GameSettings.defaultSettings());
        BoardPosition from = new BoardPosition(0, 6);
        BoardPosition to = new BoardPosition(0, 4);

        List<MoveOption> options = session.legalMovesFrom(from);
        assertTrue(options.stream().map(MoveOption::target).anyMatch(to::equals));

        Move move = session.move(from, to);

        assertEquals(MoveKind.MOVE, move.kind());
        assertEquals(PieceType.PAWN, session.board().getPiece(to).type());
        assertTrue(session.board().getPiece(to).moved());
        assertEquals(TypeColorFigure.BLACK, session.turnColor());
    }

    @Test
    void shouldDetectCheckForCurrentPlayer() {
        Board board = new Board();
        board.setPiece(new BoardPosition(4, 7), piece(PieceType.KING, TypeColorFigure.WHITE, TypeSide.DOWN));
        board.setPiece(new BoardPosition(4, 0), piece(PieceType.ROOK, TypeColorFigure.BLACK, TypeSide.UP));
        board.setPiece(new BoardPosition(7, 0), piece(PieceType.KING, TypeColorFigure.BLACK, TypeSide.UP));

        GameSession session = new GameSession(board, TypeColorFigure.WHITE, GameSettings.defaultSettings());

        assertEquals(GameStatus.CHECK, session.status());
        assertTrue(session.isKingInCheck(TypeColorFigure.WHITE));
    }

    @Test
    void shouldDetectCheckmate() {
        Board board = new Board();
        board.setPiece(new BoardPosition(0, 0), piece(PieceType.KING, TypeColorFigure.BLACK, TypeSide.UP));
        board.setPiece(new BoardPosition(0, 1), piece(PieceType.ROOK, TypeColorFigure.WHITE, TypeSide.DOWN));
        board.setPiece(new BoardPosition(1, 1), piece(PieceType.QUEEN, TypeColorFigure.WHITE, TypeSide.DOWN));
        board.setPiece(new BoardPosition(2, 2), piece(PieceType.KING, TypeColorFigure.WHITE, TypeSide.DOWN));

        GameSession session = new GameSession(board, TypeColorFigure.BLACK, GameSettings.defaultSettings());

        assertEquals(GameStatus.CHECKMATE, session.status());
        assertEquals(TypeColorFigure.WHITE, session.winnerColor());
    }

    @Test
    void shouldDetectStalemate() {
        Board board = new Board();
        board.setPiece(new BoardPosition(0, 0), piece(PieceType.KING, TypeColorFigure.BLACK, TypeSide.UP));
        board.setPiece(new BoardPosition(2, 1), piece(PieceType.KING, TypeColorFigure.WHITE, TypeSide.DOWN));
        board.setPiece(new BoardPosition(1, 2), piece(PieceType.QUEEN, TypeColorFigure.WHITE, TypeSide.DOWN));

        GameSession session = new GameSession(board, TypeColorFigure.BLACK, GameSettings.defaultSettings());

        assertEquals(GameStatus.STALEMATE, session.status());
        assertNull(session.winnerColor());
    }

    private Piece piece(PieceType type, TypeColorFigure color, TypeSide side) {
        return new Piece(type, color, side, TypeChessFigure.CLASSIC, true);
    }
}

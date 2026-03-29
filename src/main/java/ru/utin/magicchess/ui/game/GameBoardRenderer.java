package ru.utin.magicchess.ui.game;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import ru.utin.magicchess.domain.game.Board;
import ru.utin.magicchess.domain.game.BoardPosition;
import ru.utin.magicchess.domain.game.GameSession;
import ru.utin.magicchess.domain.game.MoveKind;
import ru.utin.magicchess.domain.game.MoveOption;
import ru.utin.magicchess.domain.game.Piece;
import ru.utin.magicchess.domain.game.PieceType;
import ru.utin.magicchess.game.factory.chess_figure.FigureImageRegistry;
import ru.utin.magicchess.utils.ResourceUtil;

import java.util.Optional;

public class GameBoardRenderer {
    private static final Color LIGHT_CELL = Color.web("#f3d9b1");
    private static final Color DARK_CELL = Color.web("#7b4f31");
    private static final Color SELECTED_OVERLAY = Color.web("#4caf50", 0.45);
    private static final Color MOVE_OVERLAY = Color.web("#ffeb3b", 0.45);
    private static final Color ATTACK_OVERLAY = Color.web("#f44336", 0.45);
    private static final Image CHECK_IMAGE = new Image(ResourceUtil.resourceUrl("/ru/utin/magicchess/images/chess/shah.png"));

    private final Canvas canvas;

    public GameBoardRenderer(Canvas canvas) {
        this.canvas = canvas;
    }

    public void render(GameSession gameSession, SelectionState selectionState) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        double cellSize = canvas.getWidth() / Board.SIZE;
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (int column = 0; column < Board.SIZE; column++) {
            for (int row = 0; row < Board.SIZE; row++) {
                double x = column * cellSize;
                double y = row * cellSize;
                gc.setFill((column + row) % 2 == 0 ? LIGHT_CELL : DARK_CELL);
                gc.fillRect(x, y, cellSize, cellSize);

                BoardPosition position = new BoardPosition(column, row);
                paintSelection(gc, selectionState, position, x, y, cellSize);
                paintPiece(gc, gameSession, position, x, y, cellSize);
            }
        }
    }

    public BoardPosition positionAt(double x, double y) {
        int column = (int) (x / (canvas.getWidth() / Board.SIZE));
        int row = (int) (y / (canvas.getHeight() / Board.SIZE));
        BoardPosition position = new BoardPosition(column, row);
        return position.isInsideBoard() ? position : null;
    }

    private void paintSelection(
            GraphicsContext gc,
            SelectionState selectionState,
            BoardPosition position,
            double x,
            double y,
            double cellSize
    ) {
        if (selectionState.isSelected(position)) {
            gc.setFill(SELECTED_OVERLAY);
            gc.fillRect(x, y, cellSize, cellSize);
        }
        Optional<MoveOption> moveOption = selectionState.optionAt(position);
        if (moveOption.isEmpty()) {
            return;
        }
        gc.setFill(moveOption.get().kind() == MoveKind.ATTACK ? ATTACK_OVERLAY : MOVE_OVERLAY);
        gc.fillRect(x, y, cellSize, cellSize);
    }

    private void paintPiece(GraphicsContext gc, GameSession gameSession, BoardPosition position, double x, double y, double cellSize) {
        Piece piece = gameSession.board().getPiece(position);
        if (piece == null) {
            return;
        }
        gc.drawImage(FigureImageRegistry.get(piece.species(), piece.color(), piece.type()), x, y, cellSize, cellSize);
        if (piece.type() == PieceType.KING && gameSession.isKingInCheck(piece.color())) {
            gc.drawImage(CHECK_IMAGE, x, y, cellSize, cellSize);
        }
    }
}

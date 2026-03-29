package ru.utin.magicchess.ui.game;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import ru.utin.magicchess.audio.AudioService;
import ru.utin.magicchess.audio.SoundType;
import ru.utin.magicchess.domain.game.BoardPosition;
import ru.utin.magicchess.domain.game.GameSession;
import ru.utin.magicchess.domain.game.MoveKind;

public class SinglePlayerGamePresenter {
    private static final double CANVAS_SIZE = 640;

    private final AudioService audioService;
    private final GameSession gameSession;
    private final Canvas canvas;
    private final GameBoardRenderer renderer;
    private final GameInteractionService interactionService;
    private Label statusLabel;

    public SinglePlayerGamePresenter(GameSession gameSession, AudioService audioService) {
        this.audioService = audioService;
        this.gameSession = gameSession;
        this.canvas = new Canvas(CANVAS_SIZE, CANVAS_SIZE);
        SelectionState selectionState = new SelectionState();
        this.renderer = new GameBoardRenderer(canvas);
        this.interactionService = new GameInteractionService(gameSession, selectionState);
        canvas.setOnMouseClicked(event -> onBoardClick(event.getX(), event.getY()));
    }

    public Canvas canvas() {
        return canvas;
    }

    public void bind(Label statusLabel) {
        this.statusLabel = statusLabel;
        render();
    }

    private void onBoardClick(double x, double y) {
        BoardPosition position = renderer.positionAt(x, y);
        if (position == null) {
            return;
        }
        InteractionResult result = interactionService.handleClick(position);
        if (!result.shouldRender()) {
            return;
        }
        if (result.performedMoveKind() != null) {
            audioService.playSfx(result.performedMoveKind() == MoveKind.ATTACK ? SoundType.ATTACK : SoundType.MOVE);
        }
        render();
    }

    private void render() {
        renderer.render(gameSession, interactionService.selectionState());
        if (statusLabel != null) {
            statusLabel.setText(gameSession.statusText());
        }
    }
}

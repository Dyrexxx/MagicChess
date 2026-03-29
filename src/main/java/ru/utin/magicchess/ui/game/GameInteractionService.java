package ru.utin.magicchess.ui.game;

import ru.utin.magicchess.domain.game.BoardPosition;
import ru.utin.magicchess.domain.game.GameStatus;
import ru.utin.magicchess.domain.game.GameSession;
import ru.utin.magicchess.domain.game.Move;
import ru.utin.magicchess.domain.game.MoveOption;

import java.util.List;
import java.util.Optional;

public class GameInteractionService {
    private final GameSession gameSession;
    private final SelectionState selectionState;

    public GameInteractionService(GameSession gameSession, SelectionState selectionState) {
        this.gameSession = gameSession;
        this.selectionState = selectionState;
    }

    public InteractionResult handleClick(BoardPosition position) {
        if (gameSession.status() == GameStatus.CHECKMATE || gameSession.status() == GameStatus.STALEMATE) {
            return new InteractionResult(false, null);
        }
        Optional<BoardPosition> selectedPosition = selectionState.selectedPosition();
        if (selectedPosition.isPresent()) {
            BoardPosition from = selectedPosition.get();
            if (from.equals(position)) {
                selectionState.clear();
                return new InteractionResult(true, null);
            }

            Optional<MoveOption> selectedMove = selectionState.optionAt(position);
            if (selectedMove.isPresent()) {
                Move move = gameSession.move(from, position);
                selectionState.clear();
                return new InteractionResult(true, move.kind());
            }
        }

        if (!gameSession.canSelect(position)) {
            boolean hadSelection = selectionState.selectedPosition().isPresent();
            selectionState.clear();
            return new InteractionResult(hadSelection, null);
        }

        List<MoveOption> options = gameSession.legalMovesFrom(position);
        if (options.isEmpty()) {
            boolean hadSelection = selectionState.selectedPosition().isPresent();
            selectionState.clear();
            return new InteractionResult(hadSelection, null);
        }

        selectionState.select(position, options);
        return new InteractionResult(true, null);
    }

    public SelectionState selectionState() {
        return selectionState;
    }
}

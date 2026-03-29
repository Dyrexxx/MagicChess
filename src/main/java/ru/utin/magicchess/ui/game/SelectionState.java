package ru.utin.magicchess.ui.game;

import ru.utin.magicchess.domain.game.BoardPosition;
import ru.utin.magicchess.domain.game.MoveOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SelectionState {
    private BoardPosition selectedPosition;
    private final List<MoveOption> moveOptions = new ArrayList<>();

    public Optional<BoardPosition> selectedPosition() {
        return Optional.ofNullable(selectedPosition);
    }

    public List<MoveOption> moveOptions() {
        return List.copyOf(moveOptions);
    }

    public void select(BoardPosition position, List<MoveOption> options) {
        selectedPosition = position;
        moveOptions.clear();
        moveOptions.addAll(options);
    }

    public void clear() {
        selectedPosition = null;
        moveOptions.clear();
    }

    public boolean isSelected(BoardPosition position) {
        return position.equals(selectedPosition);
    }

    public Optional<MoveOption> optionAt(BoardPosition position) {
        return moveOptions.stream()
                .filter(option -> option.target().equals(position))
                .findFirst();
    }
}

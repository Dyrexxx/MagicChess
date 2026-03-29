package ru.utin.magicchess.ui.game;

import ru.utin.magicchess.domain.game.MoveKind;

public record InteractionResult(boolean shouldRender, MoveKind performedMoveKind) {
}

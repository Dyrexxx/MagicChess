package ru.utin.magicchess.ui.game;

import ru.utin.magicchess.domain.game.GameSession;

public class GameStatusTextFormatter {
    public String format(GameSession session) {
        return switch (session.status()) {
            case ACTIVE -> "Ход: " + session.turnColor();
            case CHECK -> "Шах. Ход: " + session.turnColor();
            case CHECKMATE -> "Мат. Победил: " + session.winnerColor();
            case STALEMATE -> "Пат. Ничья";
        };
    }
}

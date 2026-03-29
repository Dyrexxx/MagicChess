package ru.utin.magicchess.app;

import ru.utin.magicchess.domain.game.GameSession;

import java.util.Optional;

public class CurrentGameHolder {
    private GameSession currentSession;

    public Optional<GameSession> currentSession() {
        return Optional.ofNullable(currentSession);
    }

    public void setSession(GameSession currentSession) {
        this.currentSession = currentSession;
    }

    public void clear() {
        currentSession = null;
    }
}

package ru.utin.magicchess.app;

import ru.utin.magicchess.audio.AudioService;
import ru.utin.magicchess.domain.game.GameSession;
import ru.utin.magicchess.domain.game.GameSettings;

public class GameStarter {
    private final CurrentGameHolder currentGameHolder;
    private final SceneNavigator sceneNavigator;
    private final AudioService audioService;

    public GameStarter(CurrentGameHolder currentGameHolder, SceneNavigator sceneNavigator, AudioService audioService) {
        this.currentGameHolder = currentGameHolder;
        this.sceneNavigator = sceneNavigator;
        this.audioService = audioService;
    }

    public void startSinglePlayer(GameSettings settings) {
        currentGameHolder.setSession(GameSession.create(settings));
        audioService.stopBgm();
        sceneNavigator.navigateTo(Screen.SINGLE_PLAYER);
    }
}

package ru.utin.magicchess.app;

import javafx.stage.Stage;
import ru.utin.magicchess.audio.AudioService;

public class AppServices {
    private final AudioService audioService;
    private final CurrentGameHolder currentGameHolder;
    private final MagicChessControllerFactory controllerFactory;
    private final SceneNavigator sceneNavigator;
    private final GameStarter gameStarter;

    public AppServices(Stage stage) {
        this.audioService = new AudioService();
        this.currentGameHolder = new CurrentGameHolder();
        this.controllerFactory = new MagicChessControllerFactory();
        this.sceneNavigator = new SceneNavigator(stage, controllerFactory);
        this.gameStarter = new GameStarter(currentGameHolder, sceneNavigator, audioService);
        controllerFactory.configure(sceneNavigator, audioService, currentGameHolder, gameStarter);
    }

    public SceneNavigator sceneNavigator() {
        return sceneNavigator;
    }
}

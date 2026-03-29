package ru.utin.magicchess.app;

import javafx.util.Callback;
import ru.utin.magicchess.audio.AudioService;
import ru.utin.magicchess.controllers.MenuController;
import ru.utin.magicchess.controllers.SettingSingleplayController;
import ru.utin.magicchess.controllers.SinglePlayerController;

public class MagicChessControllerFactory implements Callback<Class<?>, Object> {
    private SceneNavigator sceneNavigator;
    private AudioService audioService;
    private CurrentGameHolder currentGameHolder;
    private GameStarter gameStarter;

    public void configure(
            SceneNavigator sceneNavigator,
            AudioService audioService,
            CurrentGameHolder currentGameHolder,
            GameStarter gameStarter
    ) {
        this.sceneNavigator = sceneNavigator;
        this.audioService = audioService;
        this.currentGameHolder = currentGameHolder;
        this.gameStarter = gameStarter;
    }

    @Override
    public Object call(Class<?> controllerClass) {
        if (controllerClass == MenuController.class) {
            return new MenuController(sceneNavigator, audioService);
        }
        if (controllerClass == SettingSingleplayController.class) {
            return new SettingSingleplayController(gameStarter);
        }
        if (controllerClass == SinglePlayerController.class) {
            return new SinglePlayerController(currentGameHolder, audioService);
        }
        try {
            return controllerClass.getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException("Cannot create controller: " + controllerClass.getName(), e);
        }
    }
}

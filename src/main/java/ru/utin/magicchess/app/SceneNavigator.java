package ru.utin.magicchess.app;

import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.utin.magicchess.utils.StageUtil;

public class SceneNavigator {
    private final Stage stage;
    private final MagicChessControllerFactory controllerFactory;

    public SceneNavigator(Stage stage, MagicChessControllerFactory controllerFactory) {
        this.stage = stage;
        this.controllerFactory = controllerFactory;
        stage.setTitle("Magic Chess");
        stage.setMaximized(true);
        stage.show();
    }

    public void navigateTo(Screen screen) {
        Scene scene = StageUtil.createScene(screen.fxmlPath(), controllerFactory);
        stage.setScene(scene);
    }
}

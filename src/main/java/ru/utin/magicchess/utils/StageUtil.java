package ru.utin.magicchess.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.util.Callback;

import java.io.IOException;

public final class StageUtil {
    private StageUtil() {
    }

    public static Scene createScene(String src, Callback<Class<?>, Object> controllerFactory) {
        if (src == null || src.isEmpty()) {
            throw new IllegalArgumentException("FXML path is empty");
        }
        FXMLLoader fxmlLoader = new FXMLLoader(ResourceUtil.resource("/ru/utin/magicchess/" + src));
        if (controllerFactory != null) {
            fxmlLoader.setControllerFactory(controllerFactory);
        }
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load FXML: " + src, e);
        }
        return scene;
    }
}

package ru.utin.magicchess.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class StageUtil {
    public static Scene createScene(String src) {
        if (src == null || src.isEmpty()) {
            throw new IllegalArgumentException("FXML path is empty");
        }
        FXMLLoader fxmlLoader = new FXMLLoader(ResourceUtil.resource("/ru/utin/magicchess/" + src));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load FXML: " + src, e);
        }
        return scene;
    }
}

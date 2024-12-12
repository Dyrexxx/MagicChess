package ru.utin.magicchess.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.utin.magicchess.App;

import java.io.IOException;

public class StageUtil {
    public static Scene createScene(String src) {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(src));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return scene;
    }
}

package ru.utin.magicchess;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.utin.magicchess.app.AppServices;
import ru.utin.magicchess.app.Screen;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        AppServices appServices = new AppServices(stage);
        appServices.sceneNavigator().navigateTo(Screen.MENU);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
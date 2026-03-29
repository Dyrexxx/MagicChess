package ru.utin.magicchess.app;

public enum Screen {
    MENU("menu.fxml"),
    SETTING_SINGLEPLAY("setting_singleplay.fxml"),
    SINGLE_PLAYER("single_player.fxml");

    private final String fxmlPath;

    Screen(String fxmlPath) {
        this.fxmlPath = fxmlPath;
    }

    public String fxmlPath() {
        return fxmlPath;
    }
}

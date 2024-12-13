module ru.utin.magicchess {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.desktop;
    requires javafx.media;


    opens ru.utin.magicchess to javafx.fxml;
    exports ru.utin.magicchess;
    exports ru.utin.magicchess.controllers;
    opens ru.utin.magicchess.controllers to javafx.fxml;
}
package ru.utin.magicchess.game;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import lombok.Getter;
import ru.utin.magicchess.models.cells.BaseChessCell;
import ru.utin.magicchess.models.cells.parent.Cell;


public class BaseGameField {
    private static BaseGameField instance;
    @Getter
    private final Canvas canvas = new Canvas(600, 600);
    private final ControlClick controlClick = new ControlClick();
    @Getter
    private Cell[][] field;


    private BaseGameField() {
        canvas.setOnMouseClicked(event -> {
            click((int) event.getX(), (int) event.getY());
        });
        createNewGameField();

    }

    private void click(int x, int y) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (x > field[i][j].getX() && x < field[i][j].getX() + field[i][j].getSize() && y > field[i][j].getY() && y < field[i][j].getY() + field[i][j].getSize()) {
                    controlClick.click(field[i][j], i, j);
                }
            }
        }
    }

    public static BaseGameField getInstance() {
        if (instance == null) {
            synchronized (BaseGameField.class) {
                if (instance == null) {
                    instance = new BaseGameField();
                }
            }
        }
        return instance;
    }


    private void createNewGameField() {
        field = BaseChessCell.createChessField((int) canvas.getWidth());
        SettingGame.getInstance().fillGameField(field);
    }

    public void paint() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                field[i][j].draw();
            }
        }
    }
}
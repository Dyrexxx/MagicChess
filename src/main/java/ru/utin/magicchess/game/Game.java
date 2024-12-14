package ru.utin.magicchess.game;

import javafx.scene.canvas.Canvas;
import lombok.Getter;
import ru.utin.magicchess.models.cells.parent.Cell;

public class Game {
    private final BaseGameField field;
    private final ControlClick controlClick;
    @Getter
    private final Canvas canvas;

    public Game() {
        canvas = new Canvas(600, 600);
        canvas.setOnMouseClicked(event -> {
            clickOnCanvas((int) event.getX(), (int) event.getY());
        });
        field = new BaseGameField(canvas);
        controlClick = new ControlClick(field.getField());
    }

    private void clickOnCanvas(int x, int y) {
        Cell[][] localField = this.field.getField();
        for (int i = 0; i < localField.length; i++) {
            for (int j = 0; j < localField[i].length; j++) {
                if (x > localField[i][j].getX() && x < localField[i][j].getX() + localField[i][j].getSize() && y > localField[i][j].getY() && y < localField[i][j].getY() + localField[i][j].getSize()) {
                    controlClick.click(localField[i][j], i, j);
                    field.paint(canvas);
                }
            }
        }
    }
}
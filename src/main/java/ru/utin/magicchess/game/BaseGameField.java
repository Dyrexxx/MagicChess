package ru.utin.magicchess.game;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import lombok.Getter;
import ru.utin.magicchess.models.cells.BaseChessCell;
import ru.utin.magicchess.models.cells.parent.Cell;

import static ru.utin.magicchess.models.cells.BaseChessCell.changeColor;


@Getter
public class BaseGameField {
    private static final SettingFieldGame settingFieldGame;
    private final Cell[][] field;

    static {
        settingFieldGame = SettingFieldGame.getInstance();
    }

    public BaseGameField(Canvas canvas) {
        field = createChessField((int) canvas.getWidth());
        settingFieldGame.fillGameField(field);
        paint(canvas);
    }

    public void paint(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                field[i][j].draw(canvas);
            }
        }
    }

    public TurnMove getTurnMove() {
        return new TurnMove(settingFieldGame.getMyColorSide(), settingFieldGame.getOpponentColorSide());
    }

    private Cell[][] createChessField(int widthCanvas) {
        Cell[][] chessField = new BaseChessCell[8][8];
        int cellSize = widthCanvas / 8;
        for (int i = 0, x = 0; i < 8; i++, x += cellSize) {
            changeColor();
            for (int j = 0, y = 0; j < 8; j++, y += cellSize) {
                chessField[i][j] = new BaseChessCell(x, y, cellSize);
                changeColor();
            }
        }
        return chessField;
    }
}
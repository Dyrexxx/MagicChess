package ru.utin.magicchess.game;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lombok.Getter;
import ru.utin.magicchess.models.cells.BaseChessCell;
import ru.utin.magicchess.models.cells.parent.Cell;

public class BaseGameField implements SubjectField {
    @Getter
    private final Cell[][] field;
    private final TurnMove turnMove;

    public BaseGameField(Canvas canvas) {
        SettingFieldGame settings = SettingFieldGame.getInstance();
        field = createChessField((int) canvas.getWidth());
        BoardInitializer.fillField(field, settings);
        turnMove = new TurnMove(settings.getMyColorSide(), settings.getOpponentColorSide());
        paint(canvas);
    }

    @Override
    public void registerObserver(ObserverField observer) {
        observer.update(field, turnMove);
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

    private Cell[][] createChessField(int canvasWidth) {
        Cell[][] chessField = new Cell[8][8];
        int cellSize = canvasWidth / 8;
        boolean dark = true;
        for (int i = 0, x = 0; i < 8; i++, x += cellSize) {
            dark = !dark;
            for (int j = 0, y = 0; j < 8; j++, y += cellSize) {
                Color cellColor = dark ? Color.BLACK : Color.WHITE;
                chessField[i][j] = new BaseChessCell(x, y, cellSize, cellColor);
                chessField[i][j].setCoordinatesInList(i, j);
                dark = !dark;
            }
        }
        return chessField;
    }
}

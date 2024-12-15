package ru.utin.magicchess.game;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import lombok.Getter;
import ru.utin.magicchess.models.cells.BaseChessCell;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.NoFigure;

import java.util.ArrayList;
import java.util.List;

import static ru.utin.magicchess.models.cells.BaseChessCell.changeColor;


public class BaseGameField implements SubjectField {
    private static final SettingFieldGame settingFieldGame;
    @Getter
    private final Cell[][] field;
    private final TurnMove turnMove;

    static {
        settingFieldGame = SettingFieldGame.getInstance();
    }

    public BaseGameField(Canvas canvas) {
        field = createChessField((int) canvas.getWidth());
        settingFieldGame.fillGameField(field);
        turnMove = new TurnMove(settingFieldGame.getMyColorSide(), settingFieldGame.getOpponentColorSide());
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

    private Cell[][] createChessField(int widthCanvas) {
        Cell[][] chessField = new BaseChessCell[8][8];
        int cellSize = widthCanvas / 8;
        for (int i = 0, x = 0; i < 8; i++, x += cellSize) {
            changeColor();
            for (int j = 0, y = 0; j < 8; j++, y += cellSize) {
                chessField[i][j] = new BaseChessCell(x, y, cellSize);
                chessField[i][j].setCoordinatesInList(i, j);
                changeColor();
            }
        }
        return chessField;
    }

}
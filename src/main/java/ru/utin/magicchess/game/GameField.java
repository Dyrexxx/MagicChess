package ru.utin.magicchess.game;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import lombok.Getter;
import ru.utin.magicchess.models.cells.BaseChessCell;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.black.ElephantBlackFigure;
import ru.utin.magicchess.models.figures.chess.black.PawnBlackFigure;
import ru.utin.magicchess.models.figures.chess.white.ElephantWhiteFigure;
import ru.utin.magicchess.models.figures.chess.white.HorseWhiteFigure;
import ru.utin.magicchess.models.figures.chess.white.PawnWhiteFigure;


public class GameField {
    private static GameField instance;
    @Getter
    private final Canvas canvas = new Canvas(600, 600);
    private final ControlClick controlClick = new ControlClick();
    @Getter
    private Cell[][] field;


    private GameField() {
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

    public static GameField getInstance() {
        if (instance == null) {
            synchronized (GameField.class) {
                if (instance == null) {
                    instance = new GameField();
                }
            }
        }
        return instance;
    }


    private void createNewGameField() {
        field = BaseChessCell.createChessField((int) canvas.getWidth());
        field[1][3].setFigure(new PawnBlackFigure());
        field[6][4].setFigure(new PawnWhiteFigure());
        field[7][1].setFigure(new HorseWhiteFigure());
        field[5][3].setFigure(new ElephantWhiteFigure());
        field[5][4].setFigure(new ElephantBlackFigure());
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
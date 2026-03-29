package ru.utin.magicchess.models.figures.chess;

import javafx.scene.canvas.GraphicsContext;
import lombok.Getter;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.cells.ResultActiveFigureModel;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.Figure;

import static ru.utin.magicchess.utils.GameUtil.indexIsArray;

@Getter
public abstract class ChessFigure extends Figure {
    private final TypeColorFigure color;

    public ChessFigure(TypeSide typeSide, TypeColorFigure color) {
        super(typeSide);
        this.color = color;
    }

    /**
     * Пытается добавить ход/атаку для клетки (i, j) в переданную модель.
     * Возвращает тип результата: атака, ход или стоп.
     */
    protected RunType run(int i, int j, Cell[][] field, ResultActiveFigureModel model) {
        if (indexIsArray(i, j)) {
            Cell cell = field[i][j];
            Figure figure = cell.getFigure();
            if (figure instanceof ChessFigure chessFigure) {
                if (chessFigure.color != color) {
                    model.getAttackList().add(cell);
                    return RunType.ATTACK;
                } else {
                    return RunType.STOP;
                }
            } else if (figure instanceof NoFigure) {
                model.getMoveList().add(cell);
                return RunType.MOVE;
            }
        }
        return RunType.STOP;
    }

    @Override
    protected void drawImage(GraphicsContext gc, int x, int y, int size) {
        gc.drawImage(image, x, y, size, size);
    }
}

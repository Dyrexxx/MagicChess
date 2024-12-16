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
    protected TypeColorFigure type;
    private final ResultActiveFigureModel activatedModel;


    public ChessFigure(TypeSide typeSide) {
        super(typeSide);
        activatedModel = new ResultActiveFigureModel();
    }

    protected ResultActiveFigureModel sendActivatedModel() {
        ResultActiveFigureModel newActivatedModel = ResultActiveFigureModel.cloneModel(activatedModel);
        activatedModel.clear();
        return newActivatedModel;
    }

    protected RunType run(int i, int j, Cell[][] field) {
        if (indexIsArray(i, j)) {
            Cell cell = field[i][j];
            Figure figure = cell.getFigure();
            if (figure instanceof ChessFigure) {
                if (((ChessFigure) cell.getFigure()).type != type) {
                    activatedModel.getAttackList().add(cell);
                    return RunType.ATTACK;
                } else {
                    return RunType.STOP;
                }

            } else if (figure instanceof NoFigure) {
                activatedModel.getMoveList().add(cell);
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

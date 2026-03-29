package ru.utin.magicchess.models.figures.chess.abstracts;

import javafx.scene.image.Image;
import lombok.Getter;
import lombok.Setter;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.cells.ResultActiveFigureModel;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.Figure;
import ru.utin.magicchess.models.figures.chess.ChessFigure;
import ru.utin.magicchess.models.figures.chess.NoFigure;

import static ru.utin.magicchess.utils.GameUtil.indexIsArray;

@Getter
@Setter
public class Pawn extends ChessFigure {
    private boolean moved = false;

    public Pawn(TypeSide typeSide, TypeColorFigure color, Image image) {
        super(typeSide, color);
        this.image = image;
    }

    @Override
    protected ResultActiveFigureModel activated(int i, int j, Cell[][] field) {
        ResultActiveFigureModel model = new ResultActiveFigureModel();
        if (getTypeSide() == TypeSide.DOWN) {
            boolean blocked = !movePawn(i, j - 1, field, model);
            if (!moved && !blocked) {
                movePawn(i, j - 2, field, model);
            }
            attackPawn(i - 1, j - 1, field, model);
            attackPawn(i + 1, j - 1, field, model);
        } else {
            boolean blocked = !movePawn(i, j + 1, field, model);
            if (!moved && !blocked) {
                movePawn(i, j + 2, field, model);
            }
            attackPawn(i - 1, j + 1, field, model);
            attackPawn(i + 1, j + 1, field, model);
        }
        return model;
    }

    private boolean movePawn(int i, int j, Cell[][] field, ResultActiveFigureModel model) {
        if (indexIsArray(i, j) && field[i][j].getFigure() instanceof NoFigure) {
            model.getMoveList().add(field[i][j]);
            return true;
        }
        return false;
    }

    private void attackPawn(int i, int j, Cell[][] field, ResultActiveFigureModel model) {
        if (indexIsArray(i, j)) {
            Figure figure = field[i][j].getFigure();
            if (figure instanceof ChessFigure cf && cf.getColor() != getColor()) {
                model.getAttackList().add(field[i][j]);
            }
        }
    }
}

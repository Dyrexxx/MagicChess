package ru.utin.magicchess.game;

import ru.utin.magicchess.game.factory.TypeFigureModel;
import ru.utin.magicchess.game.factory.chess_figure.FigureFactory;
import ru.utin.magicchess.models.cells.parent.Cell;

/**
 * Расставляет фигуры на доске согласно настройкам игры.
 * Разделение ответственности: SettingFieldGame хранит данные, BoardInitializer выполняет действие.
 */
public final class BoardInitializer {
    private static final TypeFigureModel[] BACK_ROW = {
            TypeFigureModel.ROOK,
            TypeFigureModel.HORSE,
            TypeFigureModel.ELEPHANT,
            TypeFigureModel.QUEEN,
            TypeFigureModel.KING,
            TypeFigureModel.ELEPHANT,
            TypeFigureModel.HORSE,
            TypeFigureModel.ROOK
    };

    private BoardInitializer() {
    }

    public static void fillField(Cell[][] field, SettingFieldGame settings) {
        FigureFactory myFactory = FigureFactory.of(settings.getMySpecies(), settings.getMyColorSide());
        FigureFactory opponentFactory = FigureFactory.of(settings.getOpponentSpecies(), settings.getOpponentColorSide());
        fillSide(field, opponentFactory, TypeSide.UP);
        fillSide(field, myFactory, TypeSide.DOWN);
    }

    private static void fillSide(Cell[][] field, FigureFactory factory, TypeSide side) {
        int backRow = side == TypeSide.UP ? 0 : 7;
        int pawnRow = side == TypeSide.UP ? 1 : 6;
        for (int i = 0; i < 8; i++) {
            field[i][pawnRow].setFigure(factory.create(TypeFigureModel.PAWN, side));
            field[i][backRow].setFigure(factory.create(BACK_ROW[i], side));
        }
    }
}

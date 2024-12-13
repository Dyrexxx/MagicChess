package ru.utin.magicchess.game.factory.chess_figure.base.figure;

import ru.utin.magicchess.game.factory.TypeFigureModel;
import ru.utin.magicchess.models.figures.Figure;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;
import ru.utin.magicchess.models.figures.chess.base.white.*;
import ru.utin.magicchess.models.figures.chess.elf.white.*;

public class WhiteFigureFactory extends AbstractFigureFactory {

    @Override
    public Figure create(TypeFigureModel type) {
        System.out.println(type);
        switch (type) {
            case KING -> {
                return new BaseKingWhiteFigure();
            }
            case QUEEN -> {
                return new BaseQueenWhiteFigure();
            }
            case PAWN -> {
                return new BasePawnWhiteFigure();
            }
            case ROOK -> {
                return new BaseRookWhiteFigure();
            }
            case HORSE -> {
                return new BaseHorseWhiteFigure();
            }
            case ELEPHANT -> {
                return new BaseElephantWhiteFigure();
            }
        }
        return null;
    }
}

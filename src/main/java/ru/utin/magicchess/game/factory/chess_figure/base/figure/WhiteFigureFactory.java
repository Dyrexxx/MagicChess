package ru.utin.magicchess.game.factory.chess_figure.base.figure;

import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeFigureModel;
import ru.utin.magicchess.models.figures.Figure;
import ru.utin.magicchess.models.figures.chess.chessFigures.base.white.*;

public class WhiteFigureFactory extends AbstractFigureFactory {

    @Override
    public Figure create(TypeFigureModel type, TypeSide typeSide) {
        System.out.println(type);
        switch (type) {
            case KING -> {
                return new BaseKingWhiteFigure(typeSide);
            }
            case QUEEN -> {
                return new BaseQueenWhiteFigure(typeSide);
            }
            case PAWN -> {
                return new BasePawnWhiteFigure(typeSide);
            }
            case ROOK -> {
                return new BaseRookWhiteFigure(typeSide);
            }
            case HORSE -> {
                return new BaseHorseWhiteFigure(typeSide);
            }
            case ELEPHANT -> {
                return new BaseElephantWhiteFigure(typeSide);
            }
        }
        return null;
    }
}

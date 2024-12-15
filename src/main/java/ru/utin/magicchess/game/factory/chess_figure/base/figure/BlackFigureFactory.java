package ru.utin.magicchess.game.factory.chess_figure.base.figure;

import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeFigureModel;
import ru.utin.magicchess.models.figures.Figure;
import ru.utin.magicchess.models.figures.chess.chessFigures.base.black.*;

public class BlackFigureFactory extends AbstractFigureFactory{

    @Override
    public Figure create(TypeFigureModel type, TypeSide typeSide) {
        switch (type) {
            case KING -> {
                return new BaseKingBlackFigure(typeSide);
            }
            case QUEEN -> {
                return new BaseQueenBlackFigure(typeSide);
            }
            case PAWN -> {
                return new BasePawnBlackFigure(typeSide);
            }
            case ROOK -> {
                return new BaseRookBlackFigure(typeSide);
            }
            case HORSE -> {
                return new BaseHorseBlackFigure(typeSide);
            }
            case ELEPHANT -> {
                return new BaseElephantBlackFigure(typeSide);
            }
        }
        return null;
    }
}

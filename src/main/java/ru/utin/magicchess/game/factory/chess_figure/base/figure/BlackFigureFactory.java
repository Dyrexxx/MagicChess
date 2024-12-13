package ru.utin.magicchess.game.factory.chess_figure.base.figure;

import ru.utin.magicchess.game.factory.TypeFigureModel;
import ru.utin.magicchess.models.figures.Figure;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;
import ru.utin.magicchess.models.figures.chess.base.black.*;
import ru.utin.magicchess.models.figures.chess.elf.black.*;

public class BlackFigureFactory extends AbstractFigureFactory{

    @Override
    public Figure create(TypeFigureModel type) {
        switch (type) {
            case KING -> {
                return new BaseKingBlackFigure();
            }
            case QUEEN -> {
                return new BaseQueenBlackFigure();
            }
            case PAWN -> {
                return new BasePawnBlackFigure();
            }
            case ROOK -> {
                return new BaseRookBlackFigure();
            }
            case HORSE -> {
                return new BaseHorseBlackFigure();
            }
            case ELEPHANT -> {
                return new BaseElephantBlackFigure();
            }
        }
        return null;
    }
}

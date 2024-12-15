package ru.utin.magicchess.game.factory.chess_figure.heroes.elf.factory;

import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeFigureModel;
import ru.utin.magicchess.game.factory.chess_figure.base.figure.AbstractFigureFactory;
import ru.utin.magicchess.models.figures.Figure;
import ru.utin.magicchess.models.figures.chess.chessFigures.elf.black.*;

public class ElfBlackFactory extends AbstractFigureFactory {
    @Override
    public Figure create(TypeFigureModel type, TypeSide typeSide) {
        switch (type) {
            case KING -> {
                return new ElfKingBlackFigure(typeSide);
            }
            case QUEEN -> {
                return new ElfQueenBlackFigure(typeSide);
            }
            case PAWN -> {
                return new ElfPawnBlackFigure(typeSide);
            }
            case ROOK -> {
                return new ElfRookBlackFigure(typeSide);
            }
            case HORSE -> {
                return new ElfHorseBlackFigure(typeSide);
            }
            case ELEPHANT -> {
                return new ElfElephantBlackFigure(typeSide);
            }
        }
        return null;
    }
}

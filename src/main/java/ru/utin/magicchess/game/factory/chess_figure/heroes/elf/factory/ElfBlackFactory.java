package ru.utin.magicchess.game.factory.chess_figure.heroes.elf.factory;

import ru.utin.magicchess.game.factory.TypeFigureModel;
import ru.utin.magicchess.game.factory.chess_figure.ColorFigureFactory;
import ru.utin.magicchess.game.factory.chess_figure.base.figure.AbstractFigureFactory;
import ru.utin.magicchess.models.figures.Figure;
import ru.utin.magicchess.models.figures.chess.elf.black.*;

public class ElfBlackFactory extends AbstractFigureFactory {
    @Override
    public Figure create(TypeFigureModel type) {
        switch (type) {
            case KING -> {
                return new ElfKingBlackFigure();
            }
            case QUEEN -> {
                return new ElfQueenBlackFigure();
            }
            case PAWN -> {
                return new ElfPawnBlackFigure();
            }
            case ROOK -> {
                return new ElfRookBlackFigure();
            }
            case HORSE -> {
                return new ElfHorseBlackFigure();
            }
            case ELEPHANT -> {
                return new ElfElephantBlackFigure();
            }
        }
        return null;
    }
}

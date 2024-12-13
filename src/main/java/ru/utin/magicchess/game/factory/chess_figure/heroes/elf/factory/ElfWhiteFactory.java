package ru.utin.magicchess.game.factory.chess_figure.heroes.elf.factory;

import ru.utin.magicchess.game.factory.TypeFigureModel;
import ru.utin.magicchess.game.factory.chess_figure.ColorFigureFactory;
import ru.utin.magicchess.game.factory.chess_figure.base.figure.AbstractFigureFactory;
import ru.utin.magicchess.models.figures.Figure;
import ru.utin.magicchess.models.figures.chess.elf.white.*;

public class ElfWhiteFactory extends AbstractFigureFactory {

    public Figure create(TypeFigureModel type) {
        switch (type) {
            case KING -> {
                return new ElfKingWhiteFigure();
            }
            case QUEEN -> {
                return new ElfQueenWhiteFigure();
            }
            case PAWN -> {
                return new ElfPawnWhiteFigure();
            }
            case ROOK -> {
                return new ElfRookWhiteFigure();
            }
            case HORSE -> {
                return new ElfHorseWhiteFigure();
            }
            case ELEPHANT -> {
                return new ElfElephantWhiteFigure();
            }
        }
        return null;
    }
}

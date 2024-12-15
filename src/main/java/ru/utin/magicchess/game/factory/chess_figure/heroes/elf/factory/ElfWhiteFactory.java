package ru.utin.magicchess.game.factory.chess_figure.heroes.elf.factory;

import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeFigureModel;
import ru.utin.magicchess.game.factory.chess_figure.base.figure.AbstractFigureFactory;
import ru.utin.magicchess.models.figures.Figure;
import ru.utin.magicchess.models.figures.chess.chessFigures.elf.white.*;

public class ElfWhiteFactory extends AbstractFigureFactory {

    public Figure create(TypeFigureModel type, TypeSide typeSide) {
        switch (type) {
            case KING -> {
                return new ElfKingWhiteFigure(typeSide);
            }
            case QUEEN -> {
                return new ElfQueenWhiteFigure(typeSide);
            }
            case PAWN -> {
                return new ElfPawnWhiteFigure(typeSide);
            }
            case ROOK -> {
                return new ElfRookWhiteFigure(typeSide);
            }
            case HORSE -> {
                return new ElfHorseWhiteFigure(typeSide);
            }
            case ELEPHANT -> {
                return new ElfElephantWhiteFigure(typeSide);
            }
        }
        return null;
    }
}

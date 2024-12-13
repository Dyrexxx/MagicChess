package ru.utin.magicchess.game.factory.chess_figure.heroes.elf;

import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.game.factory.chess_figure.ColorFigureFactory;
import ru.utin.magicchess.game.factory.chess_figure.heroes.SpeciesFigureFactory;
import ru.utin.magicchess.game.factory.chess_figure.heroes.elf.factory.ElfBlackFactory;
import ru.utin.magicchess.game.factory.chess_figure.heroes.elf.factory.ElfWhiteFactory;

public class ElfFigureFactory extends SpeciesFigureFactory {

    public ElfFigureFactory(TypeColorFigure colorFigure) {
        super(colorFigure);
        if (colorFigure == TypeColorFigure.WHITE) {
            setAbstractFigureFactory(new ElfWhiteFactory());
        } else if (colorFigure == TypeColorFigure.BLACK) {
            setAbstractFigureFactory(new ElfBlackFactory());
        }

    }
}

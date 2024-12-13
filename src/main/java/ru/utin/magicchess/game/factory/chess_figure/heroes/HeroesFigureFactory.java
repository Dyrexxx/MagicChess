package ru.utin.magicchess.game.factory.chess_figure.heroes;

import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.game.factory.chess_figure.heroes.elf.ElfFigureFactory;
import ru.utin.magicchess.game.factory.chess_figure.ChessFigureFactory;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public class HeroesFigureFactory extends ChessFigureFactory{


    public HeroesFigureFactory(TypeChessFigure type, TypeColorFigure colorType) {
        if (type == TypeChessFigure.ELF) {
            setFactory(new ElfFigureFactory(colorType).getAbstractFigureFactory());
        }
    }

}

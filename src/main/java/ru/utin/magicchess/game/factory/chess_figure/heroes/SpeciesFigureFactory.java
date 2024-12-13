package ru.utin.magicchess.game.factory.chess_figure.heroes;

import lombok.Getter;
import lombok.Setter;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.game.factory.chess_figure.ColorFigureFactory;
import ru.utin.magicchess.game.factory.chess_figure.base.figure.AbstractFigureFactory;

@Setter
@Getter
public abstract class SpeciesFigureFactory {
    private AbstractFigureFactory abstractFigureFactory;

    public SpeciesFigureFactory(TypeColorFigure colorFigure) {

    }
}

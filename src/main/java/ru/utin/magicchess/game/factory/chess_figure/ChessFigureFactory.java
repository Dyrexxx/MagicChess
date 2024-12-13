package ru.utin.magicchess.game.factory.chess_figure;

import lombok.Setter;
import ru.utin.magicchess.game.factory.TypeFigureModel;
import ru.utin.magicchess.game.factory.chess_figure.base.figure.AbstractFigureFactory;
import ru.utin.magicchess.models.figures.Figure;

@Setter
public abstract class ChessFigureFactory {
    private AbstractFigureFactory factory;

    public Figure createFigure(TypeFigureModel model) {
        return factory.create(model);
    }
}

package ru.utin.magicchess.game.factory.chess_figure.base.figure;

import ru.utin.magicchess.game.factory.TypeFigureModel;
import ru.utin.magicchess.models.figures.Figure;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public abstract class AbstractFigureFactory {
    public abstract Figure create(TypeFigureModel typeFigureModel);
}

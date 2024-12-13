package ru.utin.magicchess.game.factory.chess_figure;

import ru.utin.magicchess.game.factory.TypeFigureModel;
import ru.utin.magicchess.models.figures.Figure;

public abstract class ColorFigureFactory {
    public abstract Figure create(TypeFigureModel type);
}

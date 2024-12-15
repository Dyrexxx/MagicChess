package ru.utin.magicchess.game.factory.chess_figure;

import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.game.factory.TypeFigureModel;
import ru.utin.magicchess.game.factory.chess_figure.base.BaseFigureFactory;
import ru.utin.magicchess.game.factory.chess_figure.heroes.HeroesFigureFactory;
import ru.utin.magicchess.game.factory.TypeFigure;
import ru.utin.magicchess.models.figures.Figure;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public class TypeFigureFactory {
    private ChessFigureFactory factory;

    public TypeFigureFactory(TypeFigure type, TypeChessFigure typeChessFigure, TypeColorFigure typeColorFigure) {
        if (type == TypeFigure.BASE) {
            factory = new BaseFigureFactory(typeColorFigure);
        } else if (type == TypeFigure.SPECIES) {
            factory = new HeroesFigureFactory(typeChessFigure, typeColorFigure);
        }
    }

    public Figure createFigure(TypeFigureModel model, TypeSide typeSide) {
        return factory.createFigure(model, typeSide);
    }
}

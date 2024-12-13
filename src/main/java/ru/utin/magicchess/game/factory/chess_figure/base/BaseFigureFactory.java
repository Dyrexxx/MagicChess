package ru.utin.magicchess.game.factory.chess_figure.base;

import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.game.factory.TypeFigureModel;
import ru.utin.magicchess.game.factory.chess_figure.ChessFigureFactory;
import ru.utin.magicchess.game.factory.chess_figure.base.figure.AbstractFigureFactory;
import ru.utin.magicchess.game.factory.chess_figure.base.figure.BlackFigureFactory;
import ru.utin.magicchess.game.factory.chess_figure.base.figure.WhiteFigureFactory;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public class BaseFigureFactory extends ChessFigureFactory {

    public BaseFigureFactory(TypeColorFigure type) {
        if (type == TypeColorFigure.WHITE) {
            setFactory(new WhiteFigureFactory());
        } else if (type == TypeColorFigure.BLACK) {
            setFactory(new BlackFigureFactory());
        }
    }
}

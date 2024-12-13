package ru.utin.magicchess.game;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.game.factory.TypeFigure;
import ru.utin.magicchess.game.factory.TypeFigureModel;
import ru.utin.magicchess.game.factory.chess_figure.TypeFigureFactory;
import ru.utin.magicchess.models.cells.parent.Cell;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;
import ru.utin.magicchess.models.figures.chess.base.black.*;

@Getter
@Setter
@ToString
public class SettingGame {
    private static SettingGame instance;
    private TypeColorFigure myColorSide;
    private TypeColorFigure opponentColorSide;
    private TypeFigure typeFigure;
    private TypeChessFigure speciesOpponent;
    private TypeChessFigure mySpecies;

    private SettingGame() {
    }

    public void fillGameField(Cell[][] field) {
        TypeFigureFactory myFigures = new TypeFigureFactory(typeFigure, mySpecies, myColorSide);
        TypeFigureFactory opponentFigures = new TypeFigureFactory(typeFigure, speciesOpponent, opponentColorSide);
        fillOpponentFigures(field, opponentFigures);
        fillMyFigures(field, myFigures);
    }

    private void fillOpponentFigures(Cell[][] field, TypeFigureFactory factory) {
        for (int i = 0; i < 8; i++) {
            field[i][1].setFigure(factory.createFigure(TypeFigureModel.PAWN));
        }
        field[0][0].setFigure(factory.createFigure(TypeFigureModel.ROOK));
        field[1][0].setFigure(factory.createFigure(TypeFigureModel.HORSE));
        field[2][0].setFigure(factory.createFigure(TypeFigureModel.ELEPHANT));
        field[3][0].setFigure(factory.createFigure(TypeFigureModel.QUEEN));
        field[4][0].setFigure(factory.createFigure(TypeFigureModel.KING));
        field[5][0].setFigure(factory.createFigure(TypeFigureModel.ELEPHANT));
        field[6][0].setFigure(factory.createFigure(TypeFigureModel.HORSE));
        field[7][0].setFigure(factory.createFigure(TypeFigureModel.ROOK));
    }

    private void fillMyFigures(Cell[][] field, TypeFigureFactory factory) {
        for (int i = 0; i < 8; i++) {
            field[i][6].setFigure(factory.createFigure(TypeFigureModel.PAWN));
        }
        field[0][7].setFigure(factory.createFigure(TypeFigureModel.ROOK));
        field[1][7].setFigure(factory.createFigure(TypeFigureModel.HORSE));
        field[2][7].setFigure(factory.createFigure(TypeFigureModel.ELEPHANT));
        field[3][7].setFigure(factory.createFigure(TypeFigureModel.QUEEN));
        field[4][7].setFigure(factory.createFigure(TypeFigureModel.KING));
        field[5][7].setFigure(factory.createFigure(TypeFigureModel.ELEPHANT));
        field[6][7].setFigure(factory.createFigure(TypeFigureModel.HORSE));
        field[7][7].setFigure(factory.createFigure(TypeFigureModel.ROOK));
    }

    public static SettingGame getInstance() {
        if (instance == null) {
            synchronized (SettingGame.class) {
                if (instance == null) {
                    instance = new SettingGame();
                }
            }
        }
        return instance;
    }
}

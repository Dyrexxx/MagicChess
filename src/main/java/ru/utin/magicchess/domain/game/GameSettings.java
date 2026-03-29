package ru.utin.magicchess.domain.game;

import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public record GameSettings(
        TypeColorFigure myColor,
        TypeColorFigure opponentColor,
        TypeChessFigure mySpecies,
        TypeChessFigure opponentSpecies
) {
    public GameSettings {
        if (myColor == null || opponentColor == null) {
            throw new IllegalArgumentException("Colors must be specified");
        }
        if (mySpecies == null || opponentSpecies == null) {
            throw new IllegalArgumentException("Species must be specified");
        }
    }

    public static GameSettings defaultSettings() {
        return new GameSettings(
                TypeColorFigure.WHITE,
                TypeColorFigure.BLACK,
                TypeChessFigure.CLASSIC,
                TypeChessFigure.CLASSIC
        );
    }

    public TypeColorFigure colorForSide(TypeSide side) {
        return side == TypeSide.DOWN ? myColor : opponentColor;
    }

    public TypeChessFigure speciesForSide(TypeSide side) {
        return side == TypeSide.DOWN ? mySpecies : opponentSpecies;
    }
}

package ru.utin.magicchess.domain.game;

import ru.utin.magicchess.models.figures.chess.TypeChessFigure;

public record GameSettings(
        PieceColor myColor,
        PieceColor opponentColor,
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
                PieceColor.WHITE,
                PieceColor.BLACK,
                TypeChessFigure.CLASSIC,
                TypeChessFigure.CLASSIC
        );
    }

    public PieceColor colorForSide(BoardSide side) {
        return side == BoardSide.DOWN ? myColor : opponentColor;
    }

    public TypeChessFigure speciesForSide(BoardSide side) {
        return side == BoardSide.DOWN ? mySpecies : opponentSpecies;
    }
}

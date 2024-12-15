package ru.utin.magicchess.game;

import lombok.Getter;
import ru.utin.magicchess.game.factory.TypeColorFigure;

@Getter
public class TurnMove {
    private TypeColorFigure turnColor;
    private String movedPlayer;
    private final Player yourPlayer;
    private final Player opponentPlayer;

    public TurnMove(TypeColorFigure yourColorFigure, TypeColorFigure opponentColor) {
        turnColor = TypeColorFigure.WHITE;
        this.yourPlayer = new Player(yourColorFigure);
        this.opponentPlayer = new Player(opponentColor);
        movedPlayer = turnColor == yourPlayer.getColor() ? yourPlayer.getName() : opponentPlayer.getName();
    }

    public void move() {
        turnColor = turnColor == TypeColorFigure.BLACK ? TypeColorFigure.WHITE : TypeColorFigure.BLACK;
        movedPlayer = turnColor == yourPlayer.getColor() ? yourPlayer.getName() : opponentPlayer.getName();
    }

}

package ru.utin.magicchess.game;

import lombok.Getter;
import ru.utin.magicchess.game.factory.TypeColorFigure;

@Getter
public class TurnMove {
    private TypeColorFigure turnColor;
    private final Player yourPlayer;
    private final Player opponentPlayer;

    public TurnMove(TypeColorFigure yourColorFigure, TypeColorFigure opponentColor) {
        turnColor = TypeColorFigure.WHITE;
        this.yourPlayer = new Player(yourColorFigure);
        this.opponentPlayer = new Player(opponentColor);
    }

    public void move() {
        turnColor = turnColor == TypeColorFigure.BLACK ? TypeColorFigure.WHITE : TypeColorFigure.BLACK;
    }
}

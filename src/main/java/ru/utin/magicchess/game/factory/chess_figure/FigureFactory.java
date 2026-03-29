package ru.utin.magicchess.game.factory.chess_figure;

import javafx.scene.image.Image;
import ru.utin.magicchess.game.TypeSide;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.game.factory.TypeFigureModel;
import ru.utin.magicchess.models.figures.Figure;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;
import ru.utin.magicchess.models.figures.chess.abstracts.*;

/**
 * Единая фабрика фигур.
 * Создаёт фигуру нужного типа с правильным изображением для заданной расы и цвета.
 * Для добавления новой расы достаточно зарегистрировать изображения в FigureImageRegistry.
 */
public class FigureFactory {
    private final TypeChessFigure species;
    private final TypeColorFigure color;

    private FigureFactory(TypeChessFigure species, TypeColorFigure color) {
        this.species = species;
        this.color = color;
    }

    public static FigureFactory of(TypeChessFigure species, TypeColorFigure color) {
        return new FigureFactory(species, color);
    }

    public Figure create(TypeFigureModel model, TypeSide typeSide) {
        Image image = FigureImageRegistry.get(species, color, model);
        return switch (model) {
            case KING     -> new King(typeSide, color, image);
            case QUEEN    -> new Queen(typeSide, color, image);
            case ROOK     -> new Rook(typeSide, color, image);
            case ELEPHANT -> new Elephant(typeSide, color, image);
            case HORSE    -> new Horse(typeSide, color, image);
            case PAWN     -> new Pawn(typeSide, color, image);
        };
    }
}

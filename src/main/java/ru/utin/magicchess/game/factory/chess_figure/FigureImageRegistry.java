package ru.utin.magicchess.game.factory.chess_figure;

import javafx.scene.image.Image;
import ru.utin.magicchess.game.factory.TypeColorFigure;
import ru.utin.magicchess.game.factory.TypeFigureModel;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;
import ru.utin.magicchess.utils.ResourceUtil;

import java.util.EnumMap;
import java.util.Map;

/**
 * Реестр изображений фигур.
 * Для добавления новой расы достаточно вызвать register() или registerAll().
 */
public final class FigureImageRegistry {
    private static final Map<TypeChessFigure, Map<TypeColorFigure, Map<TypeFigureModel, Image>>> registry =
            new EnumMap<>(TypeChessFigure.class);

    static {
        registerClassic();
        registerElf();
    }

    private FigureImageRegistry() {
    }

    private static void registerClassic() {
        String base = "/ru/utin/magicchess/images/chess/";
        register(TypeChessFigure.CLASSIC, TypeColorFigure.WHITE, TypeFigureModel.KING,     load(base + "white/wKing.png"));
        register(TypeChessFigure.CLASSIC, TypeColorFigure.WHITE, TypeFigureModel.QUEEN,    load(base + "white/wQueen.png"));
        register(TypeChessFigure.CLASSIC, TypeColorFigure.WHITE, TypeFigureModel.ROOK,     load(base + "white/wRook.png"));
        register(TypeChessFigure.CLASSIC, TypeColorFigure.WHITE, TypeFigureModel.ELEPHANT, load(base + "white/wElephant.png"));
        register(TypeChessFigure.CLASSIC, TypeColorFigure.WHITE, TypeFigureModel.HORSE,    load(base + "white/wHorse.png"));
        register(TypeChessFigure.CLASSIC, TypeColorFigure.WHITE, TypeFigureModel.PAWN,     load(base + "white/wPawn.png"));

        register(TypeChessFigure.CLASSIC, TypeColorFigure.BLACK, TypeFigureModel.KING,     load(base + "black/bKing.png"));
        register(TypeChessFigure.CLASSIC, TypeColorFigure.BLACK, TypeFigureModel.QUEEN,    load(base + "black/bQueen.png"));
        register(TypeChessFigure.CLASSIC, TypeColorFigure.BLACK, TypeFigureModel.ROOK,     load(base + "black/bRook.png"));
        register(TypeChessFigure.CLASSIC, TypeColorFigure.BLACK, TypeFigureModel.ELEPHANT, load(base + "black/bElephant.png"));
        register(TypeChessFigure.CLASSIC, TypeColorFigure.BLACK, TypeFigureModel.HORSE,    load(base + "black/bHorse.png"));
        register(TypeChessFigure.CLASSIC, TypeColorFigure.BLACK, TypeFigureModel.PAWN,     load(base + "black/bPawn.png"));
    }

    private static void registerElf() {
        // Эльфы пока используют те же изображения, что и классические фигуры.
        // Для добавления уникальных изображений замените конкретные вызовы register().
        for (TypeColorFigure color : TypeColorFigure.values()) {
            for (TypeFigureModel model : TypeFigureModel.values()) {
                Image image = registry.get(TypeChessFigure.CLASSIC).get(color).get(model);
                register(TypeChessFigure.ELF, color, model, image);
            }
        }
    }

    /**
     * Получает изображение для указанной расы, цвета и типа фигуры.
     */
    public static Image get(TypeChessFigure species, TypeColorFigure color, TypeFigureModel model) {
        Map<TypeColorFigure, Map<TypeFigureModel, Image>> byColor = registry.get(species);
        if (byColor == null) {
            throw new IllegalArgumentException("Неизвестная раса: " + species);
        }
        Map<TypeFigureModel, Image> byModel = byColor.get(color);
        if (byModel == null) {
            throw new IllegalArgumentException("Неизвестный цвет: " + color);
        }
        Image image = byModel.get(model);
        if (image == null) {
            throw new IllegalArgumentException("Изображение не найдено для модели: " + model);
        }
        return image;
    }

    /**
     * Регистрирует изображение для конкретной комбинации раса + цвет + тип.
     * Используется для добавления или переопределения изображений новых рас.
     */
    public static void register(TypeChessFigure species, TypeColorFigure color, TypeFigureModel model, Image image) {
        registry
                .computeIfAbsent(species, k -> new EnumMap<>(TypeColorFigure.class))
                .computeIfAbsent(color, k -> new EnumMap<>(TypeFigureModel.class))
                .put(model, image);
    }

    private static Image load(String path) {
        return new Image(ResourceUtil.resourceUrl(path));
    }
}

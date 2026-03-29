package ru.utin.magicchess.ui.game;

import javafx.scene.image.Image;
import ru.utin.magicchess.domain.game.PieceColor;
import ru.utin.magicchess.domain.game.PieceType;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;
import ru.utin.magicchess.utils.ResourceUtil;

import java.util.EnumMap;
import java.util.Map;

public final class PieceImageResolver {
    private static final Map<TypeChessFigure, Map<PieceColor, Map<PieceType, Image>>> REGISTRY =
            new EnumMap<>(TypeChessFigure.class);

    static {
        registerClassic();
        registerElf();
    }

    private PieceImageResolver() {
    }

    public static Image get(TypeChessFigure species, PieceColor color, PieceType pieceType) {
        Map<PieceColor, Map<PieceType, Image>> byColor = REGISTRY.get(species);
        if (byColor == null) {
            throw new IllegalArgumentException("Неизвестная раса: " + species);
        }
        Map<PieceType, Image> byType = byColor.get(color);
        if (byType == null) {
            throw new IllegalArgumentException("Неизвестный цвет: " + color);
        }
        Image image = byType.get(pieceType);
        if (image == null) {
            throw new IllegalArgumentException("Изображение не найдено для фигуры: " + pieceType);
        }
        return image;
    }

    private static void registerClassic() {
        String base = "/ru/utin/magicchess/images/chess/";
        register(TypeChessFigure.CLASSIC, PieceColor.WHITE, PieceType.KING, load(base + "white/wKing.png"));
        register(TypeChessFigure.CLASSIC, PieceColor.WHITE, PieceType.QUEEN, load(base + "white/wQueen.png"));
        register(TypeChessFigure.CLASSIC, PieceColor.WHITE, PieceType.ROOK, load(base + "white/wRook.png"));
        register(TypeChessFigure.CLASSIC, PieceColor.WHITE, PieceType.BISHOP, load(base + "white/wElephant.png"));
        register(TypeChessFigure.CLASSIC, PieceColor.WHITE, PieceType.KNIGHT, load(base + "white/wHorse.png"));
        register(TypeChessFigure.CLASSIC, PieceColor.WHITE, PieceType.PAWN, load(base + "white/wPawn.png"));

        register(TypeChessFigure.CLASSIC, PieceColor.BLACK, PieceType.KING, load(base + "black/bKing.png"));
        register(TypeChessFigure.CLASSIC, PieceColor.BLACK, PieceType.QUEEN, load(base + "black/bQueen.png"));
        register(TypeChessFigure.CLASSIC, PieceColor.BLACK, PieceType.ROOK, load(base + "black/bRook.png"));
        register(TypeChessFigure.CLASSIC, PieceColor.BLACK, PieceType.BISHOP, load(base + "black/bElephant.png"));
        register(TypeChessFigure.CLASSIC, PieceColor.BLACK, PieceType.KNIGHT, load(base + "black/bHorse.png"));
        register(TypeChessFigure.CLASSIC, PieceColor.BLACK, PieceType.PAWN, load(base + "black/bPawn.png"));
    }

    private static void registerElf() {
        for (PieceColor color : PieceColor.values()) {
            for (PieceType pieceType : PieceType.values()) {
                register(TypeChessFigure.ELF, color, pieceType, REGISTRY.get(TypeChessFigure.CLASSIC).get(color).get(pieceType));
            }
        }
    }

    private static void register(TypeChessFigure species, PieceColor color, PieceType pieceType, Image image) {
        REGISTRY
                .computeIfAbsent(species, key -> new EnumMap<>(PieceColor.class))
                .computeIfAbsent(color, key -> new EnumMap<>(PieceType.class))
                .put(pieceType, image);
    }

    private static Image load(String path) {
        return new Image(ResourceUtil.resourceUrl(path));
    }
}

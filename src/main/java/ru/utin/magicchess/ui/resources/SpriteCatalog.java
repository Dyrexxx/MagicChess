package ru.utin.magicchess.ui.resources;

import javafx.scene.image.Image;
import ru.utin.magicchess.domain.game.PieceColor;
import ru.utin.magicchess.domain.game.PieceType;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;
import ru.utin.magicchess.utils.ResourceManager;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public final class SpriteCatalog {
    private static final String CHECK_ICON_PATH = "/ru/utin/magicchess/images/chess/shah.png";
    private static final Map<PieceSpriteKey, String> PIECE_SPRITES = new HashMap<>();
    private static final Map<TypeChessFigure, String> SPECIES_SPRITES = new EnumMap<>(TypeChessFigure.class);

    static {
        registerClassicPieces();
        registerElfPieceAliases();
        registerSpeciesSprites();
    }

    private SpriteCatalog() {
    }

    public static Image getPieceSprite(PieceSpriteKey key) {
        String path = PIECE_SPRITES.get(key);
        if (path == null) {
            throw new IllegalArgumentException("Не найден спрайт фигуры: " + key);
        }
        return ResourceManager.createImage(path);
    }

    public static Image getSpeciesSprite(TypeChessFigure species) {
        String path = SPECIES_SPRITES.get(species);
        return path == null ? null : ResourceManager.createImage(path);
    }

    public static Image getCheckSprite() {
        return ResourceManager.createImage(CHECK_ICON_PATH);
    }

    private static void registerClassicPieces() {
        String whiteBase = "/ru/utin/magicchess/images/chess/white/";
        String blackBase = "/ru/utin/magicchess/images/chess/black/";

        registerClassicColor(whiteBase, PieceColor.WHITE, "w");
        registerClassicColor(blackBase, PieceColor.BLACK, "b");
    }

    private static void registerClassicColor(String basePath, PieceColor color, String prefix) {
        put(TypeChessFigure.CLASSIC, color, PieceType.KING, basePath + prefix + "King.png");
        put(TypeChessFigure.CLASSIC, color, PieceType.QUEEN, basePath + prefix + "Queen.png");
        put(TypeChessFigure.CLASSIC, color, PieceType.ROOK, basePath + prefix + "Rook.png");
        put(TypeChessFigure.CLASSIC, color, PieceType.BISHOP, basePath + prefix + "Elephant.png");
        put(TypeChessFigure.CLASSIC, color, PieceType.KNIGHT, basePath + prefix + "Horse.png");
        put(TypeChessFigure.CLASSIC, color, PieceType.PAWN, basePath + prefix + "Pawn.png");
    }

    private static void registerElfPieceAliases() {
        for (PieceColor color : PieceColor.values()) {
            for (PieceType pieceType : PieceType.values()) {
                PieceSpriteKey classicKey = new PieceSpriteKey(TypeChessFigure.CLASSIC, color, pieceType);
                put(TypeChessFigure.ELF, color, pieceType, PIECE_SPRITES.get(classicKey));
            }
        }
    }

    private static void registerSpeciesSprites() {
        SPECIES_SPRITES.put(TypeChessFigure.ELF, "/ru/utin/magicchess/images/species/elf.jpg");
    }

    private static void put(
            TypeChessFigure species,
            PieceColor color,
            PieceType pieceType,
            String path
    ) {
        PIECE_SPRITES.put(new PieceSpriteKey(species, color, pieceType), path);
    }
}

package ru.utin.magicchess.ui.settings;

import javafx.scene.image.Image;
import ru.utin.magicchess.models.figures.chess.TypeChessFigure;
import ru.utin.magicchess.utils.ResourceUtil;

public final class SpeciesImageResolver {
    private SpeciesImageResolver() {
    }

    public static Image resolve(TypeChessFigure species) {
        if (species == null || species == TypeChessFigure.NONE || species == TypeChessFigure.CLASSIC) {
            return null;
        }
        return switch (species) {
            case ELF -> new Image(ResourceUtil.resourceUrl("/ru/utin/magicchess/images/species/elf.jpg"));
            case CLASSIC, NONE -> null;
        };
    }
}

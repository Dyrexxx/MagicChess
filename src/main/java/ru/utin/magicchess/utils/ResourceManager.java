package ru.utin.magicchess.utils;

import javafx.scene.image.Image;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ResourceManager {
    private static final ResourceManager INSTANCE = new ResourceManager();

    private final Map<String, Image> imageCache = new ConcurrentHashMap<>();

    private ResourceManager() {
    }

    public static ResourceManager getInstance() {
        return INSTANCE;
    }

    public static Image createImage(String pathFromRoot) {
        return INSTANCE.loadImage(pathFromRoot);
    }

    private Image loadImage(String pathFromRoot) {
        return imageCache.computeIfAbsent(
                normalize(pathFromRoot),
                path -> new Image(ResourceUtil.resourceUrl(path))
        );
    }

    private String normalize(String pathFromRoot) {
        if (pathFromRoot == null || pathFromRoot.isEmpty()) {
            throw new IllegalArgumentException("Image path is empty");
        }
        return pathFromRoot.startsWith("/") ? pathFromRoot : "/" + pathFromRoot;
    }
}

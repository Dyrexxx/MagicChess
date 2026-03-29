package ru.utin.magicchess.utils;

import ru.utin.magicchess.App;

import java.net.URL;

public final class ResourceUtil {
    private ResourceUtil() {
    }

    public static URL resource(String pathFromRoot) {
        if (pathFromRoot == null || pathFromRoot.isEmpty()) {
            throw new IllegalArgumentException("Resource path is empty");
        }
        URL url = App.class.getResource(pathFromRoot.startsWith("/") ? pathFromRoot : "/" + pathFromRoot);
        if (url == null) {
            throw new IllegalArgumentException("Resource not found: " + pathFromRoot);
        }
        return url;
    }

    public static String resourceUrl(String pathFromRoot) {
        return resource(pathFromRoot).toExternalForm();
    }
}

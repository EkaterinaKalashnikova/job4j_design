package ru.job4j.cache;

import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DirFileCache extends AbstractCache<String, String> {

    private String cachingDir;

    DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }


    @Override
    public String get(String key) {
        String strong = null;
        if (cache.containsKey(key)) {
            strong = cache.get(key).get();
            if (strong == null) {
                strong = load(key);
                cache.put(key, new SoftReference<>(strong));
            }
        } else {
            strong = load(key);
            cache.put(key, new SoftReference<>(strong));
        }
        // return super.get(key);
        return strong;
    }

    @Override
    protected String load(String key) {
        String value;
        try {
            value = Files.lines(Paths.get(cachingDir + File.separator + key), StandardCharsets.UTF_8).collect(Collectors.joining());
            put(key, value);
        } catch (IOException e) {
            System.out.println("Файл не найден!!!");
            throw new IllegalArgumentException();
        }
        return value;
    }
}

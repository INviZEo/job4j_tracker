package ru.job4j.cache;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(cachingDir + key))) {
            reader.lines().forEach((x) -> sb.append(x).append(" "));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
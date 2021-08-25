package ru.job4j.cache;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class DirFileCacheTest {

    @Test
    public void load() {
        DirFileCache dirFileCache = new DirFileCache("src/main/resources");
        String str = dirFileCache.load("Names.txt");
        Assert.assertEquals(str, dirFileCache.get("Names.txt"));
    }
}
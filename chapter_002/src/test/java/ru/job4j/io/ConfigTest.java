package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        String path = "C:\\projects\\job4j_design\\chapter_002\\data\\pair_without_comment";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Petr Arsentev")
        );
    }

    @Test
    public void whenTextWithComment() {
        String path = "C:\\projects\\job4j_design\\chapter_002\\data\\text_with_comment";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("password"),
                is("Ekaterina")
        );
    }
}
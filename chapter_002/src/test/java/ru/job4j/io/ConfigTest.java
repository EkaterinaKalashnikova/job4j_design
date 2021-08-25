package ru.job4j.io;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Ignore
public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Petr Arsentev")
        );
    }

    @Test
    public void whenTextWithComment() {
        String path = "./data/text_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("password"),
                is("Ekaterina")
        );
    }
}
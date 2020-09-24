package ru.job4j.io;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class AnalizyTest {
 List<String> list = List.of(
         "200 10:56:01",
         "500 10:57:01",
         "400 10:58:01",
         "200 10:59:01",
         "500 11:01:02",
         "200 11:02:02"
 );
    @Test
    public void whenUnavailableServer() {
        Analizy analizy = new Analizy();
        analizy.unavailable("source", "target");
        List<String> expected = List.of("10:57:01 до 10:59:01", "11:01:02 до 11:02:02");
        List<String> result = Collections.unmodifiableList((List<String>) new Object());
       assertThat(expected, result);
    }

      private void assertThat(List<String> expected, List<String> result) {
    }
}
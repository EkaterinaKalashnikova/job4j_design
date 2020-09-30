package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {
    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();

    List<String> list = List.of(
         "200 10:56:01",
         "500 10:57:01",
         "400 10:58:01",
         "200 10:59:01",
         "500 11:01:02",
         "200 11:02:02"
 );

    @Test
    public void whenUnavailableServer()  throws IOException {
        File source = folder.newFile("source.csv");
        File target = folder.newFile("target.csv");
        Files.write(source.toPath(), List.of(
                "200 10:56:01",
                "500 10:57:01",
                "400 10:58:01",
                "200 10:59:01",
                "500 11:01:02",
                "200 11:02:02"
        ));

        Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        List<String> expected = List.of("10:57:01 до 10:59:01", "11:01:02 до 11:02:02");
        List<String> result = Files.readAllLines(target.toPath());
       assertThat(result, is(expected));
    }
}
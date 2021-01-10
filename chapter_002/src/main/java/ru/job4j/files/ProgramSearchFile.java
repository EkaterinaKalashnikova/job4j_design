package ru.job4j.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ProgramSearchFile {

    public static void writeFile(Args args, List<Path> fileList) throws IOException {
        Files.write(Path.of(args.logName()), fileList.stream()
                .map(Path::toString).collect(Collectors.toList()));
    }

    public static List<Path> searchFiles(Path rootFile,  Predicate<Path> predicate) throws IOException {
        SearchTerms searcher = new SearchTerms(predicate);
        Files.walkFileTree(rootFile, searcher);
        return searcher.getPaths();
    }

    public static void main(String[] args) throws IOException {
        // получили аргументы из командной строки
        Args args1 = new Args(args);
        // проверили их
        args1.valid();
        // сформировали условие по которому будет искать
        Predicate<Path> condition = PredicateFactory.createPredicate(args1);
        // Нашли файлы по этому условию
        List<Path> paths = searchFiles(
                Path.of(args1.directory()), condition
        );
        // Сохранили результат
        writeFile(args1, paths);
    }
}
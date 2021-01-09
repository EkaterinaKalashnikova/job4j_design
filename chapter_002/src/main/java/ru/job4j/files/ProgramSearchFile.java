package ru.job4j.files;

import ru.job4j.io.SearchFiles;

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

import static ru.job4j.files.SearchTerms.listPath;

public class ProgramSearchFile {

    private static Path file;
    private static Path rootFile;

    public void setFile(Path file) {
        ProgramSearchFile.file = file;
    }

    public void setRootFile(Path rootFile) {
        ProgramSearchFile.rootFile = rootFile;
    }

    public void writeFile(Args args, List<Path> fileList) throws IOException {
        Files.write(Path.of(args.logName()), fileList.stream()
                .map(Path::toString).collect(Collectors.toList()));
    }

    //public static List<Path> searchFiles(Args args, Predicate<Path> predicate) throws IOException {
    public static List<Path> searchFiles(Path rootFile, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(ext));
       // SearchFiles searcher = new SearchFiles(predicate);
        Files.walkFileTree(rootFile, searcher);
        return searcher.getPaths();
    }

    public static void main(String[] args) throws IOException {
        Args args1 = new Args(args);
        args1.valid();
        ProgramSearchFile psf = new ProgramSearchFile();
      //  Predicate<Path> predicate = SearchTerms.listPath(args);
       // List<Path> fileList = ProgramSearchFile.searchFiles(args1, predicate);
      //  List<Path> fileList = ProgramSearchFile.searchFiles();
        List<Path> fileList = listPath(args1);
        for (Path ignored : fileList) {
            System.out.println(ignored.getFileName());
        }
        psf.writeFile(args1, fileList);
    }
}

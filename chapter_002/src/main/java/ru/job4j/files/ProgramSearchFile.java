package ru.job4j.files;

import ru.job4j.io.SearchFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    public static List<Path> searchFiles(Path rootFile, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(ext));
        Files.walkFileTree(rootFile, searcher);
        return searcher.getPaths();
    }

    public static List<Path> listPath(Args args) throws IOException {
        String type = args.typeSearch();
        String ext = "";
        String target = "*", replacement = "(.*)";
        String mask1 = args.mask().replace(target, replacement);
        List<Path> list1 = new ArrayList<>();
        List<Path> list2 = new ArrayList<>();

        if (type.equals("-f")) {
            list1 = ProgramSearchFile.searchFiles(
                    Path.of(args.directory() + args.mask()), ext);
        } else if (type.equals("-m")) {
            list2 = ProgramSearchFile.searchFiles(Path.of(args.directory()), ext);
            for (Path file : list2) {
                if (file.toFile().getName().matches(mask1)) {
                    list1.add(file);
                }
            }
        } else if (type.equals("-r")) {
            list2 = ProgramSearchFile.searchFiles(Path.of(args.directory()), ext);
            Pattern pattern = Pattern.compile(mask1);
            Matcher matcher = pattern.matcher(args.pattern());
            for (Path file : list2) {
               if (file.toFile().getName().matches(mask1)) {
                  list1.add(file);
               }
            }
        }
        return list1;
    }

    public static void main(String[] args) throws IOException {
        Args args1 = new Args(args);
        args1.valid();
        ProgramSearchFile psf = new ProgramSearchFile();
        List<Path> fileList = listPath(args1);
        for (Path ignored : fileList) {
            System.out.println(ignored.getFileName());
        }
        psf.writeFile(args1, fileList);
    }
}

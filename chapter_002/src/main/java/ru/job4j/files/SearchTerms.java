package ru.job4j.files;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SearchTerms implements FileVisitor<Path> {
    private Predicate<Path> predicate;
    private List<Path> paths = new ArrayList<>();

    public SearchTerms(Args args) {

    }

    public List<Path> getPaths() {
        return paths;
    }

    public static List<Path> listPath(Args args) throws IOException {
        String type = args.typeSearch();
        String ext = "";
        String target = "*", replacement = "(.*)";
        String mask1 = args.mask().replace(target, replacement);
        List<Path> list1 = new ArrayList<>();
        List<Path> list2 = new ArrayList<>();

        if (type.equals("-f")) {
            list1 = ProgramSearchFile.searchFiles(Path.of(args.directory() + args.mask()), ext);
           // list1 = ProgramSearchFile.searchFiles(args, path -> );
        } else if (type.equals("-m")) {
            list2 = ProgramSearchFile.searchFiles(Path.of(args.directory()), ext);
            for (Path file : list2) {
                if (file.toFile().getName().matches(mask1)) {
                    list1.add(file);
                }
            }
        } else if (type.equals("-r")) {
            list2 = ProgramSearchFile.searchFiles(Path.of(args.directory()), ext);
            Pattern pattern = Pattern.compile(args.mask());
            for (Path file : list2) {
                Matcher matcher = pattern.matcher(file.toFile().getName()); //передана строка
                if (matcher.find()) {
                    list1.add(file);
                }
            }
        }
        return list1;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}




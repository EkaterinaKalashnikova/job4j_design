package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

import static java.nio.file.FileVisitResult.CONTINUE;
import static java.nio.file.FileVisitResult.TERMINATE;

public class SearchAll implements FileVisitor<Path> {

    // private static final String FILE__NAME = null;
   // private static final Path START__DIR = null;
    private String fileName;
    private Path startDir;

    public SearchAll(String fileToSearch, Path startingDir) {
        this.fileName = fileToSearch;
        this.startDir = startingDir;
    }

    @Override
    public FileVisitResult preVisitDirectory(
            Path dir, BasicFileAttributes attrs) {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        String fileName = file.getFileName().toString();
        if (Objects.equals(startDir, fileName)) {
            System.out.println("File found: " + file.toString());
            return TERMINATE;
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        System.out.println("Failed to access file: " + file.toString());
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        throw new AssertionError();
    }

    public static void main(String[]args) throws IOException {
        Path startingDir = Paths.get("C:\\projects\\job4j_design");
        String fileToSearch = "result.txt";
        SearchAll crawler = new SearchAll(fileToSearch, startingDir);
        Files.walkFileTree(startingDir, crawler);
    }


    public Path getStartDir() {
        return startDir;
    }

    public String getFileName() {
        return fileName;
    }
}

package ru.job4j.files;

import ru.job4j.io.SearchFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProgramSearchFile {

    private static Path file;
    private static Path fileNameSearch;
    private static Path rootFile;

    public ProgramSearchFile(Path fileNameSearch, Path rootFile) {
        this.fileNameSearch = fileNameSearch;
        this.rootFile = rootFile;
    }

    public static void setFile(Path file) {
        ProgramSearchFile.file = file;
    }

    public List<Path> searchFiles() throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(".txt"));
        Files.walkFileTree(rootFile, searcher);
        return searcher.getPaths();
    }

    public  void  writeFile(Args args, List<Path> fileList) throws IOException {
        Files.write(Path.of(args.directory()), fileList.stream().map(Path::toString).collect(Collectors.toList()));
    }

    public static void main(String[] args) throws IOException {
        Args args1 = new Args(args);
        args1.valid();
        ProgramSearchFile psf = new ProgramSearchFile(Path.of("D:\\"), rootFile);
        List<Path> fileList = psf.searchFiles();
        for (Path ignored : fileList) {
            System.out.println(file.getFileName());
        }
        Predicate<Path> accord = Path::isAbsolute;
        psf.writeFile(args1, fileList);
    }

    /** public  static  void searchFiles(File rootFile, List<File> filesList) {
         if (rootFile.isDirectory()) {
             System.out.println("D:\\" + rootFile.getAbsolutePath());
             File[] directoryFiles = rootFile.listFiles();
             if (directoryFiles != null) {
                 Arrays.stream(directoryFiles).filter(file -> file.isDirectory ())
                         .forEach(file -> searchFiles(file, filesList));
             } else {
                 if (file.getName().toLowerCase().endsWith(".txt")) {
                     filesList.add(file);
                 }
             }
         }
     }*/
}

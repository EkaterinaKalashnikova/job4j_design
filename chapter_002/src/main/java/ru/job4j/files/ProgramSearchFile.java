package ru.job4j.files;

import ru.job4j.io.SearchFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ProgramSearchFile  {

    private static Path file;
    private static Path rootFile;

    public void setFile(Path file) {
        ProgramSearchFile.file = file;
    }

    public void setRootFile(Path rootFile) {
        ProgramSearchFile.rootFile = rootFile;
    }

    public static List<Path> searchFiles(Path rootFile, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(ext));
       // SearchFiles searcher = new SearchFiles(precept);
        Files.walkFileTree(rootFile, searcher);
        return searcher.getPaths();
    }

    public  void  writeFile(Args args, List<Path> fileList) throws IOException {
        Files.write(
                Path.of(args.output()), fileList.stream().map(
                        Path::toString).collect(Collectors.toList()));
    }

    public static List<Path> listPath(Args args) {
        String type = args.typeSearch();
        if (type.equals("-f")) {
           //
            Pattern.quote(args.getClass().getName());
        } else if (type.equals("-m")) {
            Pattern p = Pattern.compile(type);
        } else if (type.equals("-r")) {
            Predicate<Path> predicate1 = path -> path.toFile().getName().matches(".");
            predicate1 = (Predicate<Path>) listPath(args);
        }
        return listPath(args);
    }

    public static void main(String[] args) throws IOException {
        Args args1 = new Args(args);
        args1.valid();
        ProgramSearchFile psf = new ProgramSearchFile();
        //Predicate<Path> precept = SearchFile.predicate(args1);
        List<Path> fileList = listPath(args1);

        for (Path ignored : fileList) {
            System.out.println(file.getFileName());
       }
      psf.writeFile(args1, fileList);
       //Predicate<Path> precept = Path::isAbsolute;
        //psf.writeFile(args1, fileList);
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

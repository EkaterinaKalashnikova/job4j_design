package ru.job4j.io;

import ru.job4j.files.Args;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFiles extends SimpleFileVisitor<Path> {

    private  final Predicate<Path> predicate;
    private  final List<Path> files =  new ArrayList<>();

   public SearchFiles(Predicate<Path> predicate) {
        this.predicate = predicate;
   }

    public List<Path> getFiles() {
        return files;
    }

      @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
          if (file == null) {
              throw new IllegalArgumentException("file is null");
          }
          if (predicate.test(file)) {
                files.add(file);
            }
        // System.out.println("file name:" + file.getFileName());
          return FileVisitResult.CONTINUE;
    }

    public List<Path> getPaths() {
     return this.files;
    }
}

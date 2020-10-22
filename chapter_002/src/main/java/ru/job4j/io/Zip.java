package ru.job4j.io;

import javax.sound.midi.Patch;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    /**
     * Метод поиска поиск файлов типа ArgZip, исключая заданное расширение
     */
    public static List<Path> search(ArgZip argZip) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> !p.toFile().getName().endsWith(argZip.exclude()));
        Files.walkFileTree(Paths.get(argZip.directory()), searcher);
        return searcher.getPaths();
     }

    /**
     * Метод упаковки нескольких файлов и запись каталога для каждого пустого каталога
     * @param sources Список файлов
     * @param target конечный результат записи
     */
    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File source : sources) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод упаковки файла и запись каталога для каждого пустого каталога
     * @param source Переданный файл
     * @param target конечный результат записи
     */
    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод упаковки всей директории и создание архивной папки
     * @param args массив переданных аргументов типа ArgZip
     */
    public static void main(String[] args) throws IOException {
        ArgZip argZip = new ArgZip(args);
        argZip.valid();
        List<Path> files = search(argZip);
        Zip zip = new Zip();
        new Zip().packFiles(files.stream().map(Path::toFile).collect(Collectors.toList()),
                new File(argZip.output()));
        new Zip().packSingleFile(
                new File("./chapter_005/pom.xml"),
                new File("./chapter_005/pom.zip")
        );
    }
}

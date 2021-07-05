package ru.job4j.cache;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Emulator {
    public void init(Scanner scanner)  {
        DirFileCache dirFileCache = null;
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Выбрать: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 1) {
                System.out.println("=== Введите название директории ====");
                String s = scanner.nextLine();
                dirFileCache = new DirFileCache(s);
            } else if (select == 2) {
                System.out.println("=== Загрузить содержимое файла в кэш ====");
                System.out.print("Ведите имя: ");
                String name = scanner.nextLine();
                assert dirFileCache != null;
                dirFileCache.load(name);
                System.out.println(String.format("Файл с именем %s загружен", name));
            } else if (select == 3) {
                System.out.println("=== Получить содержимое файла по названию ====");
                System.out.print("Введите файл: ");
                String name = scanner.nextLine();
                assert dirFileCache != null;
                String s = dirFileCache.get(name);
                System.out.println(s);
            } else if (select == 4) {
                run = false;
            } else {
                System.out.println("Ну и че те надо?");
            }
        }
    }

    private void showMenu() {
        System.out.println("Меню: ");
        System.out.println("1 - указать кэшируемую директорию");
        System.out.println("2 - загрузить содержимое файла в кэш");
        System.out.println("3 - получить содержимое файла из кэша");
        System.out.println("4 - Выход");
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        new Emulator().init(scanner);
    }
}





package ru.job4j.files;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PredicateFactory {

    public static Predicate<Path> createPredicate(Args args) {

        // по умолчанию мы ищем любой файл. Это заглушка чтобы не было исключений
        Predicate<Path> condition = p -> true;
        // если нам сказали искать по имени
        if ("-f".equals(args.typeSearch())) {
            // то формируем соответстующий предикат
            condition = p -> {
                // получили имя файла
                String fileName = p.toFile().getName();
                // Мы обращаемся к значению по ключу -n
                // делаем проверку что переданное имя и имя текущего файла совпадают
                return fileName.equals(args.valKey());
            };
        } else if ("-m".equals(args.typeSearch())) {
            String target = "*", replacement = "(.*)";
            String mask1 = args.valKey().replace(target, replacement);
            condition = p -> {
                // получили имя файла
                String fileName = p.toFile().getName();
                // поиск по маске  спомощью метода matches(). Мы обращаемся к значению по ключу -n
                // делаем проверку что имя текущего файла удовлетворяют переданной маске
                return fileName.matches(mask1);
            };
        } else if ("-r".equals(args.typeSearch())) {
            condition = p -> {
                // получили имя файла
                String fileName = p.toFile().getName();
                //поиск по регулярному выражению с помощью шаблона(pattern) и метода, который ищет совпадения
                //по регулярному выражению и имени текущего файла
                Pattern pattern = Pattern.compile(args.valKey()); //шаблон регулярного выражения
                Matcher matcher = pattern.matcher(fileName); //передана строка
                return matcher.find();
            };
        }
        return condition;
    }
}

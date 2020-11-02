package ru.job4j.io;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.*;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path; //от пользователя все
    private final String botAnswers; //точный ответ от бота

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat("./chapter_002/data/botAnswer", "./chapter_002/data/chatBox");
        cc.run();
    }

    public void run() throws IOException {
        boolean def = true; //идет поток ответов в чате
        //список ответов от бота
        List<String> response = new ArrayList<>();
        //и кодировку
       // Charset charset = Charset.forName("WINDOWS-1251");
        Charset charset = UTF_8;
        //создаем список вопросов и считываем все поступающие сообщения от пользователя
        List<String> offers = Files.readAllLines(Path.of(path), charset);
        //читать ввод с консоли
        Scanner scanner = new Scanner(System.in);
        //возвращает логический тип данных, который соответствует новой строке String, которую содержит объект Scanner
        String userAnswers = " ";
        while (!OUT.equalsIgnoreCase(userAnswers)) {
            System.out.print("Ваш вопрос здесь: ");
            //Перемещает сканер за текущую строку и возвращает пропущенный ввод.
             userAnswers = scanner.nextLine();
                if (STOP.equalsIgnoreCase(userAnswers)) {
                    def = false;
                }
                if (CONTINUE.equalsIgnoreCase(userAnswers)) {
                    def = true;
                }
                if (def) {
                    //генерируем случайное число для поиска ответа
                    //получаем рандомный индекс
                    int randomIndex = (int) (Math.random() * offers.size());
                    // получаем ответ по этому индексу
                    String botResponse = offers.get(randomIndex);
                    //и записываем его в ответную строку
                    //String botResponse = String.valueOf(Math.random() * offers.size());
                    //добавляем в список ответов
                    response.add(botResponse);
                    System.out.println("Получите ответ: " +  botResponse);
                } else {
                    OUT.equalsIgnoreCase(userAnswers);
                }
            }
        Files.write(Path.of(botAnswers), response);
    }
}

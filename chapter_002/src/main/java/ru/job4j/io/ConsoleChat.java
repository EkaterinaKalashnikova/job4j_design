package ru.job4j.io;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import org.apache.commons.io.FileUtils ;

public class ConsoleChat {
    private final String path; //от пользователя все
    private final String botAnswers; //точный ответ от бота
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";


    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() throws IOException {
        boolean work = true; // идет поток вопросов в чате
        boolean def = true; //идет поток ответов в чате
        //список ответов от бота
        List<String> response = new ArrayList<>();
       // кодировку
        Charset charset = Charset.forName("WINDOWS-1251");
        //создаем список вопросов и считываем все поступающие сообщения от пользователя
        List<String> offers = Files.readAllLines(Path.of(path), charset);
        //читать ввод с консоли
        Scanner scanner = new Scanner(System.in);
        //возвращает логический тип данных, который соответствует новой строке String, которую содержит объект Scanner
        while (scanner.hasNextLine()) {
            System.out.println("Ваш вопрос здесь: ");
            //Перемещает сканер за текущую строку и возвращает пропущенный ввод.
            String userAnswers = scanner.nextLine();
          //  if (work) {
                //! OUT.equalsIgnoreCase(userAnswers);
                if (STOP.equalsIgnoreCase(userAnswers)) {
                    def = false;
                }
                if (CONTINUE.equalsIgnoreCase(userAnswers)) {
                    def = true;
                }
                if (def) {
                    //генерируем случайное число для поиска ответа
                    //и записываем его в ответную строку
                    String botResponse = String.valueOf(Math.random() * offers.size());
                    //добавляем в список ответов
                    response.add(botResponse);
                    System.out.println("Получите ответ: ");
                } else {
                    OUT.equalsIgnoreCase(userAnswers);
                }
            }
            Files.write(Path.of(botAnswers), response);
        }
  //  }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat("c:\\projects\\job4j\\", "");
        cc.run();
    }
}

package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] num = text.toString().split(System.lineSeparator());
            for (int i = 0; i <= num.length; i++) {
                int[] array = new int[ num.length ];
                array[ i ] = Integer.parseInt(num[ i ]);
                if (i  % 2 == 0) {
                    boolean rsl = true;
                }
                System.out.println(array[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

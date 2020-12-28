package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Horses {
    private final String breed;

    public Horses( String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Horse{"
                + "breed='" + breed + '\''
                + '}';
    }

    public static void main(String[] args) {
        final Horse horse = new Horse(false, 4, new Horses("english"), "Black", "Red");

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(horse));

        /* Модифицируем json-строку*/
        final String horseJson =
                "{"
                        + "\"sex\" :false,"
                        + "\"age\" :4,"
                        + "\"horses\":"
                        + "{"
                        + "\"breed\":" + "english"
                        + "},"
                        + "\"suites\":"
                        + "[\"Black\", \"Red\"]"
                        + "}";
        final Horse horse1Mod = gson.fromJson(horseJson, Horse.class);
        System.out.println(horse1Mod);
    }
}

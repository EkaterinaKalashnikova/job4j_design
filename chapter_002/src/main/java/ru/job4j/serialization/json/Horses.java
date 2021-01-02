package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Horses {
    private final String breed;

    public Horses(String breed) {
        this.breed = breed;
    }

    public static void main(String[] args) {

        /* JSONObject из json-строки строки */
        JSONObject jsonHorses = new JSONObject("{\"breed\":\"english\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("Piligrim");
        list.add("Koroleva");
        list.add("Agat");
        JSONArray jsonSuites = new JSONArray(list);

        /* JSONObject напрямую методом put */
      final Horse horse = new Horse(false, 4, new Horses("riding"), "Black", "Red");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", horse.isSex());
        jsonObject.put("age", horse.getAge());
        jsonObject.put("horses", jsonHorses);
        jsonObject.put("alias", jsonSuites);

        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());

        /* Преобразуем объект horse в json-строку */
        System.out.println(new JSONObject(horse).toString());
    }

    @Override
    public String toString() {
        return "Horses{"
                + "breed='" + breed + '\''
                + '}';
    }
}
// final Horse horse = new Horse(false, 4, new Horses("english"), "Black", "Red");

        /* Преобразуем объект person в json-строку.
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(horse));*/

        /* Модифицируем json-строку
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
        System.out.println(horse1Mod);*/



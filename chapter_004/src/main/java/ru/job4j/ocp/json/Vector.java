package ru.job4j.ocp.json;

import com.google.gson.GsonBuilder;
import org.json.JSONObject;

import java.util.List;

public class Vector {
    public static void main(String[] args) {
        var users = List.of(
                new User("123", "456"),
                new User("abc", "xyz"),
                new User("job4j", "junior")
        );
        var lib = new GsonBuilder().create();
        String json = lib.toJson(users);
        System.out.println(json);

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(users).toString());

        /* Преобразуем json-строку в объект person*/
        System.out.println(lib.fromJson(json, User.class));
    }
}


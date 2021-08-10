package ru.job4j.ocp.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VectorTest {

    @Test
    public void getListUsersWhenSerializeThenCorrect() {
        List<User> list = Arrays.asList(new User("Maria", "Larshina"),
                new User("Roman", "Mashko"));

        Gson gson = new Gson();
        String jsonString = gson.toJson(list);
        String expectedString = "[{\"name\":\"Maria\",\"lastName\":\"Larshina\"}," + "{\"name\":\"Roman\",\"lastName\":\"Mashko\"}]";

        assertEquals(expectedString, jsonString);
    }

    @Test
    public void getJsonStringWhenDeserializeThenReturnListUsers() {
        String inputString = "[{\"name\":\"Maria\",\"lastName\":\"Larshina\"}," + "{\"name\":\"Roman\",\"lastName\":\"Mashko\"}]";
        List<User> inputList = Arrays.asList(new User("Maria", "Larshina"), new User("Roman", "Mashko"));

        Type listUsers = new TypeToken<ArrayList<User>>() { }.getType();

        Gson gson = new Gson();
        List<User> outputList = gson.fromJson(inputString, listUsers);

        assertEquals(inputList, outputList);
    }
}
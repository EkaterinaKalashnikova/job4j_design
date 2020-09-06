package ru.job4j.statistica;

import org.junit.Test;
import static ru.job4j.statistica.Analize.Info;
import static ru.job4j.statistica.Analize.User;
import  static org.hamcrest.core.Is.is;
import  static org.junit.Assert.assertThat;
import java.util.*;


public class AnalizeTest {

    @Test
    public void whenItemsAdded() {
        List<User> previous = new ArrayList<>();
        List<User> current = new ArrayList<>();
        previous.add(new User(1, "Laura"));
        Analize.Info info = new Analize().diff(previous,
                List.of(new User(1, "Laura"),
                new User(2, "Robert")));
        Info expected = new Info(1, 0, 0);
        assertThat(expected, is(info));
    }

    @Test
    public void whenItemsChanged() {
        List<User> previous = new ArrayList<>();
        List<User> current = new ArrayList<>();
        previous.add(new User(1, "Laura"));
        previous.add(new User(3, "Maric"));
        Analize.Info info = new Analize().diff(previous,
                List.of(new User(1, "Laura"),
                        new User(2, "Robert")));
        Analize.Info expected = new Info(1, 0, 1);
        assertThat(expected, is(info));
    }

    @Test
    public void whenItemsRemoved() {
        List<User> previous = new ArrayList<>();
        List<User> current = new ArrayList<>();
        previous.add(new User(1, "Laura"));
        previous.add(new User(2, "Robert"));
        previous.add(new User(3, "Maric"));
        Analize.Info info = new Analize().diff(previous,
                List.of(new User(1, "Laura"),
                        new User(2, "Robert")));
        Analize.Info expected = new Info(0, 0, 1);
        assertThat(expected, is(info));
    }

    @Test
    public void whenItemsNotChanged() {
        List<User> previous = new ArrayList<>();
        List<User> current = new ArrayList<>();
        previous.add(new User(1, "Laura"));
        previous.add(new User(2, "Robert"));
        Analize.Info info = new Analize().diff(previous,
                List.of(new User(1, "Laura"),
                        new User(2, "Robert")));
        Analize.Info expected = new Info(0, 0, 0);
        assertThat(expected, is(info));
    }

    @Test
    public void whenItemsChangedName() {
        List<User> previous = new ArrayList<>();
        List<User> current = new ArrayList<>();
        previous.add(new User(1, "Laura"));
        previous.add(new User(2, "Maric"));
        Analize.Info info = new Analize().diff(previous,
                List.of(new User(1, "Laura"),
                        new User(2, "Robert")));
        Analize.Info expected = new Info(0, 1, 0);
        assertThat(expected, is(info));
    }
}
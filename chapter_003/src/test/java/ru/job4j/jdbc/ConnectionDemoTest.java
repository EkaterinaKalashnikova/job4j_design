package ru.job4j.jdbc;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConnectionDemoTest {
    @Test
    public  void  whenLoadThenGetFile() throws IOException {
        ConnectionDemo connectionDemo = new ConnectionDemo();
        ClassLoader loader = ConnectionDemo.class.getClassLoader();
        try (InputStream stream = loader.getResourceAsStream("appJDBC.properties")) {
            connectionDemo.load(stream);
        }
        String url = connectionDemo.getValue("url");
        String username = connectionDemo.getValue("username");
        String password = connectionDemo.getValue("password");
        assertThat(url, is("jdbc:postgresql://localhost:5432/idea_db"));
        assertThat(username, is("Ekaterina"));
        assertThat(password, is("kindness"));
    }
}
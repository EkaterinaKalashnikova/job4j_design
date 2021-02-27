package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionDemo {
    private final Properties prs = new Properties ();

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //регистрируем драйвера
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/idea_db";
        String login = "postgres";
        String password = "kindness";
        //устанавливаем соединение
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            if (connection != null) {
                DatabaseMetaData metaData = connection.getMetaData();
                try (ResultSet resultSet = metaData.getCatalogs()) {
                    while (resultSet.next()) {
                        System.out.println(metaData.getUserName());
                        System.out.println(metaData.getURL());
                    }
                    resultSet.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void load(InputStream io) {
        try {
            this.prs.load(io);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        return this.prs.getProperty(key);
    }
}

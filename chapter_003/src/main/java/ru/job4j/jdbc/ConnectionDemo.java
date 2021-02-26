package ru.job4j.jdbc;

import java.sql.*;

public class ConnectionDemo {
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
                    resultSet.close ();
                    connection.close ();
                } catch (SQLException e) {
                    e.printStackTrace ();
                }
            }
        }
    }
}

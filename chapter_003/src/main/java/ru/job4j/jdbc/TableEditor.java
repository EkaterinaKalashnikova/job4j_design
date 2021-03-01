package ru.job4j.jdbc;

import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    private Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(properties.getProperty("url"));
        properties.getProperty("username");
        properties.getProperty("password");
    }

    //создание запросов
    private void execute(String sql) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //создает пустую таблицу без столбцов с указанным именем
    public void createTable(String tableName) {
        String sql = String.format(
                "create table %s (%s, %s);",
                tableName,
                "id serial primary key",
                "name varchar(255)"
        );
        execute(sql);
    }

     //удаляет таблицу по указанному имени
    public void dropTable(String tableName) {
        String sql = String.format("drop table %s", tableName);
        execute(sql);
    }

     //добавляет столбец в таблицу
    public void addColumn(String tableName, String columnName, String type) {
        String sql = String.format("alter table %s add column %s, %s", tableName, columnName, type);
        execute(sql);
    }

      //удаляет столбец из таблицы
    public void dropColumn(String tableName, String columnName) {
        String sql = String.format("alter table %s drop column %s", tableName, columnName);
        execute(sql);
    }

      //переименовывает столбец
    public void renameColumn(String tableName, String columnName, String newColumnName) {
        String sql = String.format("alter table %s rename column %s, %s", tableName, columnName, newColumnName);
        execute(sql);
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}

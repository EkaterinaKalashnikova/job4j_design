package ru.job4j.db;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection cn;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item)  {
            try (PreparedStatement statement =
                         cn.prepareStatement("insert into items (name) values(?)",
                                 Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, item.getName());
                statement.execute();
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        item.setId(generatedKeys.getString(1));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean result = false;
        try (PreparedStatement statement =
                     cn.prepareStatement("update items set name = ? where id = ?")) {
            statement.setString(1, item.getName());
            statement.setInt(2, Integer.parseInt(id));
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        try (PreparedStatement statement =
                     cn.prepareStatement("delete from items where id = ?")) {
            statement.setInt(1, Integer.parseInt(id));
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement("select * from items")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String id = resultSet.getString("id");
                    Item item = new Item(name, id);
                    items.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement("select * from items where name = ?")) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    key = resultSet.getString("name");
                    statement.setString(1, key);
                    Item item = new Item(key);
                    result.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Item findById(String id) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement("select * from items where  id = ?")) {
            statement.setInt(1, Integer.parseInt(id));
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    id = resultSet.getString("id");
                    //statement.setInt(1, Integer.parseInt(id));
                    Item item = new Item(id);
                    result.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  result.size() == 1 ? result.get(0) : null;
    }
}

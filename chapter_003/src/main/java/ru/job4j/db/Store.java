package ru.job4j.db;

import java.sql.SQLException;
import java.util.List;

public interface Store extends AutoCloseable {
    void init();
    Item add(Item item) throws SQLException;
    boolean replace(String id, Item item);
    boolean delete(String id);
    List<Item> findAll();
    List<Item> findByName(String key);
    Item findById(String id);

    public static void main(String[] args) {
            Input validate = new ValidateInput(
                    new ConsoleInput()
            );
            try (Store tracker = new SqlTracker()) {
                tracker.init();
                UserAction[] actions = {
                        new CreateAction()
                };
                new StartUI().init(validate, tracker, actions);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

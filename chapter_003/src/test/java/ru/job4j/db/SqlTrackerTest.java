package ru.job4j.db;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SqlTrackerTest {
    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws SQLException {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name"));
            Assert.assertThat(tracker.findByName("name").size(), is(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void updateItem() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            List<Item> itemList = tracker.findAll();
             tracker.replace("id", new Item("name"));
           // Assert.assertEquals(itemList.contains(b), itemList.contains("id"));
            Assert.assertThat(tracker.findByName("name").get(Integer.parseInt("id")), is(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void removeItem() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            List<Item> itemList = tracker.findAll();
            boolean id = tracker.delete("id");
            Assert.assertFalse(itemList.contains(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAll() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            List<Item> all = tracker.findAll();
            System.out.println(all);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByName() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
           tracker.findByName("name");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findById() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.findById("id");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
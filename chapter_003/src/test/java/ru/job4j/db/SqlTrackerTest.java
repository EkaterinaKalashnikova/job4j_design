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
    public void createItem()  {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = tracker.add(new Item("name"));
            Item result = tracker.findById(item.getId());
            Assert.assertThat(result.getId(), is(item.getId()));
            Assert.assertThat(result.getName(), is(item.getName()));
           // Assert.assertThat(tracker.findByName("name").size(), is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void updateItem() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item[] items = new Item[4];
            items[0] = tracker.add(new Item("Anna", "1"));
            items[1] = tracker.add(new Item("Mark", "2"));
            Item expected = new Item("Lila", "2");
            expected.setId(items[2].getId());
            tracker.replace(items[2].getId(), expected);
            Item result = tracker.findById(items[2].getId());
            Assert.assertThat(result.getId(), is(expected.getId()));
            Assert.assertThat(result.getName(), is(expected.getName()));
           } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void removeItem() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = tracker.add(new Item("Mark", "2"));
            Assert.assertNotNull(tracker.findById(item.getId()));
            tracker.delete(item.getId());
            Assert.assertNull(tracker.findById(item.getId()));
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAll() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item[] items = new Item[2];
            items[0] = tracker.add(new Item("Anna", "1"));
            items[1] = tracker.add(new Item("Lila", "2"));
            Item[] rsl = tracker.findAll().toArray(new Item[0]);
            for (int i = 0; i < items.length; i++) {
                System.out.println(rsl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByName() {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = tracker.add(new Item("Anna", "1"));
            Item[] rsl = tracker.findByName("Anna").toArray(new Item[0]);
            assertThat(rsl[0].getId(), is(item.getId()));
            assertThat(rsl[0].getName(), is(item.getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
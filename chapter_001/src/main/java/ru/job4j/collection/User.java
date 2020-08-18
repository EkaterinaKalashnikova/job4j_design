package ru.job4j.collection;

import java.util.*;
import java.util.Calendar;
import java.util.Map;

public class User {

    /**
     * Поле имени пользователя.
     * Поле количества детей.
     * Поле дня рождения
     */
    private String name;
    private int children;
    private Calendar birthday;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    /**
     * Конструктор инициализации класса по трем полям
     *
     * @param name     - имя пользователя
     * @param children - количество детей
     * @param birthday - дни рождения
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Map<User, Object> users = new HashMap<>();
        users.put(new User("Nikita", 2, Calendar.getInstance()), 1);
        users.put(new User("Nikita", 2, Calendar.getInstance()), 1);
       // users.put(new User("Pavel", 1, Calendar.getInstance()), 1);
        users.forEach((key, value) -> System.out.printf("Key: %s  Value: %s \n", key, value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return getChildren() == user.getChildren() &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getBirthday(), user.getBirthday());
    }

  @Override
    public int hashCode() {
        return Objects.hash(getName(), getChildren(), getBirthday());
    }

    @Override
    public String toString() {
        return "User{"+
                "name='" + name + '\''+
                ", children=" + children +
                ", birthday=" + birthday +
                '}';
    }
}

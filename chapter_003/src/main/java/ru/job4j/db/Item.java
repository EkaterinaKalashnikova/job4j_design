package ru.job4j.db;

import java.util.Objects;

public class Item implements Comparable<Item> {
    private String id;
    private String name;

    public Item(String name, String id) {
        this.id = id;
        this.name = name;
    }

    public Item(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("items{");
        sb.append("id = ' ").append(id).append(" ' ");
        sb.append(", name = ' ").append(name).append(" ' ");
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Item item) {
        return this.name.compareTo(item.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Item)) {
            return false;
        }
        Item item = (Item) o;
        return id.equals(item.id) && name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

package ru.job4j.statistica;

import org.hamcrest.Matcher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analize {
    public Info diff(List<User> previous, List<User>  current) {
        Map<Integer, User> currMap = new HashMap<>();
        Info info = new Info();
        for (User user : previous) {
            currMap.put(user.getId(), user);
        }
        for (User user : current) {
           User find = currMap.get(user.getId());
            if (find == null) {
                info.added++;
             } else if (!find.equals(user)) {
                info.changed++;
            }
        }
        info.deleted = (previous.size() + info.added) - current.size();
        return info;
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return  id;
        }

        public String getName() {
            return  name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof User)) {
                return false;
            }
            User user = (User) o;

            if (getId() != user.getId()) {
                return false;
            }
            return getName().equals(user.getName());
        }

        @Override
        public int hashCode() {
            int result = getId();
            result = 31 * result + getName().hashCode();
            return result;
        }
    }

    public static class Info  {
        int added;
        int changed;
        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        public Info() {
        }

        @Override
        public String toString() {
            return String.format("Info{added=%d, changed=%d, deleted=%d}", added, changed, deleted);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Info)) {
                return false;
            }

            Info info = (Info) o;

            if (added != info.added) {
                return false;
            }
            if (changed != info.changed) {
                return false;
            }
            return deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            int result = added;
            result = 31 * result + changed;
            result = 31 * result + deleted;
            return result;
        }
    }
}

package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

public class MemExample {
    private final List<Integer> mem = new ArrayList<>();
    public int findById(String id) {
        for (int index = 0; index < mem.size(); index++) {
            if (this.mem.get(index).equals(id)) {
                return index;
            }
        }
        return -1;
    }
}






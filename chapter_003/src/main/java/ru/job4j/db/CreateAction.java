package ru.job4j.db;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return  "=== Create a new Item ==== ";
    }

    @Override
    public boolean execute(Input input, MemTracker tracker) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name, 4);
        tracker.add(item);
        return true;
    }
}

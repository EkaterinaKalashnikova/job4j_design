package ru.job4j.db;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
   /* boolean run = true;
        while (run) {
        this.showMenu(actions);
        int select = input.askInt("Select: ", actions.size());
        UserAction action = actions.get(select);
        run = action.execute(input, tracker);
    }*/


    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu:");
        for (int index = 0; index < actions.size(); index++) {
            System.out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        MemTracker tracker = new MemTracker();
        List<Item> actions = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            //Thread.sleep(100);
            Item item = new Item("Ekaterina" + i, i + "");
            boolean items = actions.add(item);
            System.out.println(items);
        }
        //  actions.add(new CreateAction());
        // actions.add(new ListAction());
        //actions.add(new ChangeAction());
        // actions.add(new DeleteAction());
        // actions.add(new FindByIdAction());
        //  actions.add(new FindByItemAction());
        // new StartUI().init(validate, tracker, actions);
    }

    void init(Input validate, Store tracker, UserAction[] actions) {
    }
}

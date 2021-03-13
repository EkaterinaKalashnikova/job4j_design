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

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
      //  actions.add(new CreateAction());
       // actions.add(new ListAction());
        //actions.add(new ChangeAction());
       // actions.add(new DeleteAction());
       // actions.add(new FindByIdAction());
      //  actions.add(new FindByItemAction());
       // new StartUI().init(validate, tracker, actions);
    }

    public void init(Input validate, Store tracker, UserAction[] actions) {
    }
}

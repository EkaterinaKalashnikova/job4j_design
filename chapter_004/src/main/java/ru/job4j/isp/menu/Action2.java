package ru.job4j.isp.menu;

public class Action2 implements Action {

    @Override
    public void changEl(IElement iElement) {
        String changEl = iElement.getName().substring(0, 6);
        System.out.println("Change name " + changEl);
    }
}

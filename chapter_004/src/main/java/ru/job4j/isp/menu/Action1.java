package ru.job4j.isp.menu;

public class Action1 implements Action {

    @Override
    public void changEl(IElement iElement) {
        String changEl = iElement.getName().replace("Задача", "Chapter");
        System.out.println("Read the problem " + changEl);
    }
}

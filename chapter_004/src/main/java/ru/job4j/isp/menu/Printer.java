package ru.job4j.isp.menu;

import java.util.Stack;

public class Printer {
    private static String prefix = "";

    public static void printElement(IElement ielement) {
        Stack<IElement> ielementStack = new Stack<>();

        //System.out.println(element.getName());
        ielementStack.push(ielement);
        while (!ielementStack.isEmpty()) {

            IElement ielement1 = ielementStack.pop();

            System.out.println(prefix + ielement1.getName());

            for (IElement e : ielement1.getElements()) {
                prefix = prefix + "--";
                printElement(e);
                prefix = prefix.substring(0, prefix.length() - 2);
            }
        }
    }
}



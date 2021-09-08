package ru.job4j.dip.printsolution;

public class HtmlPrinter implements IPrinter {

    @Override
    public void print(String text) {
        System.out.println("Печать в html");
    }
}

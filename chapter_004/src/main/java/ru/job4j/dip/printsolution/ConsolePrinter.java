package ru.job4j.dip.printsolution;

public class ConsolePrinter implements IPrinter {
    @Override
    public void print(String text) {
        System.out.println("Печать на консоль");
    }
}

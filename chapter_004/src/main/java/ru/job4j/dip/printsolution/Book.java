package ru.job4j.dip.printsolution;

public class Book {
    public String text;
    public IPrinter printer;

    public Book(IPrinter printer) {
        this.printer = printer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public IPrinter getPrinter() {
        return printer;
    }

    public void setPrinter(IPrinter printer) {
        this.printer = printer;
    }

    public void print() {
        printer.print(text);
    }
}

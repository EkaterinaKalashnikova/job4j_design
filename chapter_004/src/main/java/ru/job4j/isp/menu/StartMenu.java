package ru.job4j.isp.menu;

import java.util.Scanner;

public class StartMenu {
    public void init(Scanner scanner, IElement element) {
        //boolean run = true;
        while (true) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());

            if (select == 0) {
                System.out.println("=== Root Item ====");
                Printer.printElement(element);

            } else if (select == 1) {
                System.out.println("=== Find a item ====");
                String str = scanner.nextLine();
                IElement element1 = ElementAct.findElement(str, element);
                System.out.println(element1);

            } else if (select == 2) {
                System.out.println("=== Show item ====");
                String str = scanner.nextLine();
                IElement el = ElementAct.findElement(str, element);
                Printer.printElement(el);

            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                String str = scanner.nextLine();
                IElement deleteElement = ElementAct.deleteElement(str, element);
                if (deleteElement != null) {
                    System.out.println("Item was delete");
                } else {
                    System.out.println("Item not found");
                }

            } else if (select == 4) {
                System.out.println("=== Add item ====");
                System.out.println("=== Enter a name for the new item ====");
                String newEl = scanner.nextLine();
                System.out.println("=== Where to add ====");
                String parentEl = scanner.nextLine();
                IElement addElement = ElementAct.addElement(newEl, ElementAct.findElement(parentEl, element));
                System.out.println("Item was add: " + addElement);

            } else if (select == 5) {
                System.out.println("=== Make action ====");
                System.out.println("=== specify the name of the item ====");
                String str = scanner.nextLine();
                ElementAct.changeElement(str, element);

            } else if (select == 6) {
                System.out.println("=== Exit Program ====");
                break;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Root Item"); //вывод от корневого элемента всех элементов
        System.out.println("1. Find a item"); //найти нужный элемент
        System.out.println("2. Show item"); //показать элемент
        System.out.println("3. Delete item"); //удалить элемент
        System.out.println("4. Add item"); //добавить элемент
        System.out.println("5. Make action"); //сделать действие
        System.out.println("6. Exit Program"); //закрыть программу
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IElement iElement = new Element("Задача 1", new Action1());
        IElement iElement1 = new Element("Задача 1.1.", new Action2());
        IElement iElement2 = new Element("Задача 1.1.1.", new Action3());
        IElement iElement3 = new Element("Задача 1.1.2.", new Action1());
        IElement iElement4 = new Element("Задача 1.2.", new Action1());
        IElement iElement5 = new Element("Задача 1.3.", new Action2());
        IElement iElement6 = new Element("Задача 1.3.1", new Action2());
        IElement iElement7 = new Element("Задача 1.3.2", new Action3());
        IElement iElement8 = new Element("Задача 1.1.2.1", new Action3());
        iElement3.addElements(iElement8);
        iElement5.addElements(iElement7);
        iElement5.addElements(iElement6);
        iElement1.addElements(iElement2);
        iElement1.addElements(iElement3);
        iElement.addElements(iElement5);
        iElement.addElements(iElement1);
        iElement.addElements(iElement4);
        new StartMenu().init(scanner, iElement);
    }
}

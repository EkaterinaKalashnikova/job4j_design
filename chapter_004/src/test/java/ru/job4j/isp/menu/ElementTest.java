package ru.job4j.isp.menu;

import org.junit.jupiter.api.Test;

class ElementTest {

    @Test
    void addElements() {
        IElement iElement = new Element("Задача 1", new Action2());
        IElement iElement1 = new Element("Задача 1.1.", new Action2());
        IElement iElement2 = new Element("Задача 1.1.1.", new Action3());
        IElement iElement3 = new Element("Задача 1.1.2.", new Action2());
        IElement iElement4 = new Element("Задача 1.2.", new Action2());
        IElement iElement5 = new Element("Задача 1.3.", new Action2());
        IElement iElement6 = new Element("Задача 1.3.1", new Action2());
        IElement iElement7 = new Element("Задача 1.3.2", new Action3());
        IElement iElement8 = new Element("Задача 1.1.2.1", new Action3());
        iElement5.addElements(iElement7);
        iElement5.addElements(iElement6);
        iElement3.addElements(iElement8);
        iElement1.addElements(iElement2);
        iElement1.addElements(iElement3);
        iElement.addElements(iElement5);
        iElement.addElements(iElement1);
        iElement.addElements(iElement4);
        Printer.printElement(iElement);
    }
}
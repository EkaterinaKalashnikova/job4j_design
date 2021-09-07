package ru.job4j.isp.menu;

import java.util.*;

public class ElementAct {

    public static IElement findElement(String name, IElement element) {
        IElement res = null;
        Stack<IElement> iElementStack = new Stack<>();
        iElementStack.push(element);
        loop:
        while (res == null && !iElementStack.isEmpty()) {
            IElement iElement1 = iElementStack.pop();
            if (iElement1.getName().equals(name)) {
                res = iElement1;
                break loop;
            }

            for (IElement e : iElement1.getElements()) {
                res = findElement(name, e);
                if (res != null) {
                    break;
                }
            }
        }
        return res;
    }

    public static IElement deleteElement(String name, IElement element) {
        IElement deletEl = null;
        Stack<IElement> elementStack = new Stack<>();
        elementStack.push(element);
        loop:
        while (!elementStack.isEmpty()) {
            IElement parentEl = elementStack.pop();
            for (IElement e : parentEl.getElements()) {
                if (e.getName().equals(name)) {
                    deletEl = parentEl.deletEl(e);
                    break loop;
                }
            }
            elementStack.addAll(parentEl.getElements());
        }
        return deletEl;
    }

    public static IElement addElement(String name, IElement element) {
        IElement elementNew = new Element(name, new Action3());
        element.addElements(elementNew);
        return elementNew;
    }

    public static void changeElement(String name, IElement element) {
        IElement changeElement = ElementAct.findElement(name, element);
        changeElement.makeEl();
    }
}

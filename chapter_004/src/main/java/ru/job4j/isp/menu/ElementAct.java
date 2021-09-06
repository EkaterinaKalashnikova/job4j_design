package ru.job4j.isp.menu;


import java.util.*;
import java.util.function.Consumer;

public class ElementAct {

    public static IElement findElement(String name, IElement element) {
        IElement res = null;
        Stack<IElement> ielementStack = new Stack<>();
        ielementStack.push(element);
        loop:
        while (res == null && !ielementStack.isEmpty()) {
            IElement ielement1 = ielementStack.pop();
            if (ielement1.getName().equals(name)) {
                res = ielement1;
                break loop;
            }
//            if (ielement1.getElements().isEmpty()) {
//                return null;
//            }
            for (IElement e : ielement1.getElements()) {
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
//            if(deletEl != null) {
//                break;
//            }
            elementStack.addAll(parentEl.getElements());
        }
        return deletEl;
    }

    public static IElement addElement(String name, IElement element) {
        IElement elementNew = new Element(name);
        element.addElements(elementNew);
        return elementNew;
    }

    public static IElement changeElement(String name, IElement element, Consumer<IElement> elConsumer) {
        findElement(name, element);
        IElement elementUpdate = new Element(name);
        elConsumer.accept(element);
        return elementUpdate;
    }
}

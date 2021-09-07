package ru.job4j.isp.menu;

import java.util.List;

public interface IElement {
    void addElements(IElement element);

    String getName();

    void setName(String name);

    List<IElement> getElements();

    void setElements(List<IElement> elements);

    IElement deletEl(IElement iElement);

    void makeEl();
}

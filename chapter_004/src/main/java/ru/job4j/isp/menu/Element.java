package ru.job4j.isp.menu;

import java.util.ArrayList;
import java.util.List;

public class Element implements IElement {
    private String name; // name
    private List<IElement> iElements = new ArrayList<>();

    public Element(String name) {
        this.name = name;
    }

    public Element(String name, List<IElement> iElements) {
        this.name = name;
        this.iElements = iElements;
    }

    @Override
    public void addElements(IElement iElement) {
        iElements.add(iElement);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<IElement> getElements() {
        return iElements;
    }

    @Override
    public void setElements(List<IElement> iElements) {
        this.iElements = iElements;
    }

    @Override
    public IElement deletEl(IElement iElement) {
        IElement el = null;
       if(iElements.remove(iElement)) {
           el = iElement;
       }
       return el;
    }


    @Override
    public String toString() {
        return "Element{" +
                "name='" + name + '\'' +
                '}';
    }
}

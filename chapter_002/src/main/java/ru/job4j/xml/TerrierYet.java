package ru.job4j.xml;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "terrierYet")

public class TerrierYet {
    private String name;

    public TerrierYet() {

    }

    public TerrierYet(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TerrierYet{"
                + "name='" + name + '\''
                + '}';
    }
}

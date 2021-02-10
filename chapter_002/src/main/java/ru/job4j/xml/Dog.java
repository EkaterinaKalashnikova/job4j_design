package ru.job4j.xml;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Dog {
    private final boolean sex;
    private final int age;
    private final Terrier terrier;
    private final String[] breeds;

    public Dog(boolean sex, int age, Terrier terrier, String... breeds) {
        this.sex = sex;
        this.age = age;
        this.terrier = terrier;
        this.breeds = breeds;
    }

    public static void main(String[] args) throws ParserConfigurationException,
            TransformerException, IOException {
        final Dog dog = new Dog(false, 5, new Terrier("Josefina"), "West", "Russel", "York");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element dog1 = document.createElement("dog");
        Element terrier1 = document.createElement("terrier");
        Element breeds1 = document.createElement("breeds");
        Element breed = document.createElement("breed");
        Element breed1 = document.createElement("breed1");
        Element breed2 = document.createElement("breed2");

        Text text = document.createTextNode("West");
        Text text1 = document.createTextNode("Russel");
        Text text2 = document.createTextNode("York");

        document.appendChild(dog1);
        dog1.appendChild(terrier1);
        dog1.appendChild(breeds1);
        breeds1.appendChild(breed);
        breeds1.appendChild(breed1);
        breeds1.appendChild(breed2);

        breed.appendChild(text);
        breed1.appendChild(text1);
        breed2.appendChild(text2);
        dog1.setAttribute("sex", "false");
        dog1.setAttribute("age", "5");
        terrier1.setAttribute("name", "Josefina");

      //  Transformer t = TransformerFactory.newInstance().newTransformer();
      //  t.setOutputProperty(OutputKeys.INDENT, "yes");
      //  t.transform(new DOMSource(document), new StreamResult(new FileOutputStream("temp.xml")));
        DOMImplementation impl = document.getImplementation();
        DOMImplementationLS implLS = (DOMImplementationLS) impl.getFeature("LS", "3.0");
        LSSerializer ser = implLS.createLSSerializer();
        ser.getDomConfig().setParameter("format-pretty-print", true);
       // String str = ser.writeToString(document);
       // System.out.println(str);
        LSOutput out = implLS.createLSOutput();
        out.setEncoding("UTF-8");
        out.setByteStream(Files.newOutputStream(Paths.get("temp.xml")));
        ser.write(document, out);
    }

    @Override
    public String toString() {
        return "Dog{"
                + "sex=" + sex
                + ", age=" + age
                + ", terrier=" + terrier
                + ", breeds=" + Arrays.toString(breeds)
                + '}';
    }

}
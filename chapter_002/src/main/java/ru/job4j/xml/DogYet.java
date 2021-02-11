package ru.job4j.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "dogYet")
@XmlAccessorType(XmlAccessType.FIELD)

public class DogYet {

    //private static Object book;
    @XmlAttribute
    private  boolean sex;

    @XmlAttribute
    private  int age;
    private  TerrierYet terrierYet;

    // @XmlElementWrapper(name = "breeds")
    // @XmlElement(name = "breed")
    private  String[] breeds;

    public DogYet() {

    }

    public DogYet(boolean sex, int age, TerrierYet terrierYet, String... breeds) {
        this.sex = sex;
        this.age = age;
        this.terrierYet = terrierYet;
        this.breeds = breeds;
    }

    public static void main(String[] args) throws JAXBException {
        final DogYet dogYet = new DogYet(false, 5, new TerrierYet("Josefina"), "West", "Russel", "York");

        JAXBContext context = JAXBContext.newInstance(DogYet.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

       String xml = "";
        try (StringWriter writer = new StringWriter()) {
            // Сериализуем
            marshaller.marshal(dogYet, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Для сериализации нам нужно создать десериализатор
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            // десериализуем
            DogYet result = (DogYet) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
      //  marshaller.marshal(book, new File("./book.xml"));
      /*  try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(dog, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception ignored) {

        }*/
    }

    @Override
    public String toString() {
        return "DogYet{"
                + "sex=" + sex
                + ", age=" + age
                + ", terrierYet=" + terrierYet
                + ", breeds=" + Arrays.toString(breeds)
                + '}';
    }


}

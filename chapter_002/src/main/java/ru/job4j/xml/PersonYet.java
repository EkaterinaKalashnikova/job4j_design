package ru.job4j.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)

public class PersonYet {
    @XmlAttribute
    private boolean sex;

    @XmlAttribute
    private int age;

    private ContactYet contactYet;

   // @XmlElementWrapper(name = "statuses")
   // @XmlElement(name = "status")
    private String[] statuses;

    public PersonYet() { }

    public PersonYet(boolean sex, int age, ContactYet contactYet, String... statuses) {
        this.sex = sex;
        this.age = age;
        this.contactYet = contactYet;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "PersonYet{"
                + "sex=" + sex
                + ", age=" + age
                + ", contactYet=" + contactYet
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }

    public static void main(String[] args) throws JAXBException {

        final PersonYet personYet = new PersonYet(false, 30, new ContactYet("11-111"), "Worker", "Married");

        JAXBContext context = JAXBContext.newInstance(Person.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        //marshaller.marshal(book, new File("./book.xml"));
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(personYet, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception ignored) {

        }
    }
}

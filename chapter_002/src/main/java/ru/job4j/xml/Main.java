package ru.job4j.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        PersonYet personYet = new PersonYet(false, 30, new ContactYet("11-111"), "Worker", "Married");
        // Получаем контекст для доступа к АПИ
        JAXBContext context = JAXBContext.newInstance(PersonYet.class);
        // Создаем сериализатор
        Marshaller marshaller = context.createMarshaller();
        // Указываем, что нам нужно форматирование
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            // Сериализуем
            marshaller.marshal(personYet, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        // Для сериализации нам нужно создать десериализатор
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            // десериализуем
            PersonYet result = (PersonYet) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }

        //marshaller.marshal(book, new File("./book.xml"));
    }
}


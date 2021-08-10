package ru.job4j.ocp.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException {
        var users = new ArrayList<>(List.of(
                new User("123", "456"),
                new User("abc", "xyz"),
                new User("job4j", "junior")
        ));
        // Получаем контекст для доступа к АПИ
        JAXBContext context = JAXBContext.newInstance(Users.class);
        // Создаем сериализатор
        Marshaller marshaller = context.createMarshaller();
        // Указываем, что нам нужно форматирование
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(new Users(users), writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Для сериализации нам нужно создать десериализатор
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            // десериализуем
            User result = (User) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }

    @XmlRootElement(name = "users")
    public static class Users {

        private List<User> users;

        public Users() {
        }

        public Users(List<User> users) {
            this.users = users;
        }

        public List<User> getUsers() {
            return users;
        }

        public void setUsers(List<User> users) {
            this.users = users;
        }
    }
}

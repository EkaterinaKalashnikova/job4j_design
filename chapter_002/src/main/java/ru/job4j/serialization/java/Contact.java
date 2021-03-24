package ru.job4j.serialization.java;

import java.io.*;
import java.nio.file.Files;

public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    private final int zipCode;
    private final String phone;

    public Contact(int zipCode, String phone) {
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Contact contact = new Contact(123456, "+7 (111) 111-11-11");

        /* Запись объекта в файл */
        //File tempFile = Files.createTempFile(null, null).toFile();
        File tempFile = File.createTempFile("hello", ".tmp");
        System.out.println("Temp file On Default Location: " + tempFile.getAbsolutePath());
        tempFile = File.createTempFile("hello", ".tmp", new File("C:/"));
        System.out.println("Temp file On Specified Location: " + tempFile.getAbsolutePath());

        try (FileOutputStream fos = new FileOutputStream(tempFile);
             ObjectOutputStream oos =
                     new ObjectOutputStream(fos)) {
            oos.writeObject(contact);
            oos.flush(); //монопольный доступ к объекту
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        /* Чтение объекта из файла*/
        try (FileInputStream fis = new FileInputStream(tempFile);
             ObjectInputStream ois =
                     new ObjectInputStream(fis)) {
            final Contact contactFromFile = (Contact) ois.readObject();
            System.out.println(contactFromFile);
            ois.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{" +  "zipCode=" + zipCode + ", phone='" + phone + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
        return true;
        }
        if (!(o instanceof Contact)) {
            return false;
        }

        Contact contact = (Contact) o;
        if (getZipCode() != contact.getZipCode()) {
            return false;
        }
        return getPhone() != null ? getPhone().equals(contact.getPhone()) : contact.getPhone() == null;
    }

    @Override
    public int hashCode() {
        int result = getZipCode();
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        return result;
    }
}

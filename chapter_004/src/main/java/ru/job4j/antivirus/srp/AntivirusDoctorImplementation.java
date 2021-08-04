package ru.job4j.antivirus.srp;

public class AntivirusDoctorImplementation implements AntivirusDoctor {
    @Override
    public String scanFiles(String virus) {
        System.out.println("virus found");
        return "";
    }

    @Override
    public void cure() {
        System.out.println("files disinfected successfully");
    }
}

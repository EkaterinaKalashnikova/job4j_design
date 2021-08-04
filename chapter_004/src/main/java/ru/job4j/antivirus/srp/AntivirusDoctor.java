package ru.job4j.antivirus.srp;

public interface AntivirusDoctor {
    String scanFiles(String virus);
    void cure();
}

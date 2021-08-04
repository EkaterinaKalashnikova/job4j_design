package ru.job4j.antivirus.srp;

public interface AntivirusGenesis {
    String scanFiles(String virus);

    String searchSpies(String spy);

    void cure();

    void clean();
}

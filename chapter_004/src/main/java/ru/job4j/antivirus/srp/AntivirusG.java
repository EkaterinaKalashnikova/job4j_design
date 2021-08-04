package ru.job4j.antivirus.srp;

public class AntivirusG implements AntivirusGenesis {

    @Override
    public String scanFiles(String virus) {
        return "no viruses detected";
    }

    @Override
    public String searchSpies(String spy) {
        return "no spies found";
    }

    @Override
    public void cure() {

    }

    @Override
    public void clean() {

    }
}

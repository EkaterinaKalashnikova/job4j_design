package ru.job4j.antivirus.srp;

public class AntivirusReseacherImplementation implements AntivirusResearcher {
    @Override
    public String searchSpies(String spy) {
        System.out.println("spy found");
        return "";
    }

    @Override
    public void clean() {
        System.out.println("the system is cleared of spies");
    }
}

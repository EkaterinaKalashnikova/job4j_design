package ru.job4j.antivirus.srp;

public class AntivirusGen implements AntivirusDoctor, AntivirusResearcher, AntivirusGenesis {
    private AntivirusDoctor doctor;
    private AntivirusResearcher researcher;

    public AntivirusGen(AntivirusDoctor doctor, AntivirusResearcher researcher) {
        this.doctor = doctor;
        this.researcher = researcher;
    }

    @Override
    public String scanFiles(String virus) {
        System.out.println("no viruses detected");
        return "";
    }

    @Override
    public void cure() {
        System.out.println("files disinfected successfully");
    }

    @Override
    public String searchSpies(String spy) {
        System.out.println("no spies found");
        return "";
    }

    @Override
    public void clean() {
        System.out.println("the system is cleared of spies");
    }
}

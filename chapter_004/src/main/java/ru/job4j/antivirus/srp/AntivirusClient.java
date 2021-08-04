package ru.job4j.antivirus.srp;

public class AntivirusClient {

    public static void main(String[] args) {
        AntivirusGenesis antivirusGenesis = new AntivirusGen(new AntivirusDoctorImplementation(), new AntivirusReseacherImplementation());
        antivirusGenesis.scanFiles("virus");
        antivirusGenesis.cure();
        antivirusGenesis.searchSpies("spy");
        antivirusGenesis.clean();
    }
}

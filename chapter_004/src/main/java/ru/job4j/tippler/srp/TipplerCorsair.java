package ru.job4j.tippler.srp;

public class TipplerCorsair implements Tippler {

    @Override
    public void pourOperation(String drink) {
        System.out.println("give rum!!!");
    }

    @Override
    public void drinkUpOperation() {
        System.out.println("For luck)))");
    }

    @Override
    public void takeBiteOperation() {
        System.out.println("The pirate is fed!");
    }
}
